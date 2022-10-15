package com.walletmanagement.shared.auditorAware;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.walletmanagement.entities.UserEntity;

public class AuditorAwareImpl implements AuditorAware<UserEntity> {

  @Override
  public Optional<UserEntity> getCurrentAuditor() {
    UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return Optional.of(user);
  }

}
