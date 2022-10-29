package com.walletmanagement.shared.auditorAware;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.modules.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<UserEntity> {

  private static final String ANONYMOUS_USER = "anonymousUser";

  private final UserRepository userRepository;

  @Override
  public Optional<UserEntity> getCurrentAuditor() {
    String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (username.equals(ANONYMOUS_USER) || username.isEmpty()) {
      return Optional.empty();
    }

    UserEntity user = userRepository.findByUsername(username);
    return Optional.of(user);
  }

}
