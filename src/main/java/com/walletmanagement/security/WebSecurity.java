package com.walletmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurity {

  private final AuthService authService;
  private final AuthenticationEntryPoint authenticationEntryPoint;
  private final BCryptPasswordEncoder passwordEncoder;

  @Bean
  @SneakyThrows
  public SecurityFilterChain filterChain(HttpSecurity http) {
    AuthenticationManagerBuilder authenticationManagerBuilder = http
        .getSharedObject(AuthenticationManagerBuilder.class);

    authenticationManagerBuilder
        .userDetailsService(authService)
        .passwordEncoder(this.passwordEncoder);

    AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

    http.headers().frameOptions().disable();
    http.csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .cors()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/user/**")
        .permitAll()
        .antMatchers("/error/**")
        .permitAll()
        .antMatchers(
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/webjars/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .authenticationManager(authenticationManager)
        .addFilter(new JWTAuthenticationFilter(authenticationManager, authService))
        .addFilter(new JWTAuthorizationFilter(authenticationManager, authService))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    return http.build();
  }

}
