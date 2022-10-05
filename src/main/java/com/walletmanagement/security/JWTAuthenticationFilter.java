package com.walletmanagement.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.security.dto.AuthenticationResponseDto;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final AuthService authService;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AuthService authService) {
    this.authenticationManager = authenticationManager;
    this.authService = authService;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      UserEntity credentials = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
      UserEntity user = (UserEntity) authService.loadUserByUsername(credentials.getUsername());

      UsernamePasswordAuthenticationToken userAuthentication = new UsernamePasswordAuthenticationToken(
          credentials.getUsername(),
          credentials.getPassword(),
          user.getAuthorities());

      return authenticationManager.authenticate(userAuthentication);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException, ServletException {
    String token = JWT.create()
        .withSubject(authResult.getName())
        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
        .sign(Algorithm.HMAC512(SecurityConstants.SECRET));

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

    response.getWriter().write(
        new ObjectMapper().writeValueAsString(
            new AuthenticationResponseDto(token)));
  }

}
