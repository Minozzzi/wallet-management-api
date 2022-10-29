package com.walletmanagement.shared.auditorAware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.modules.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PersistenceConfig {

  private final UserRepository userRepository;

  @Bean
  AuditorAware<UserEntity> auditorProvider() {
    return new AuditorAwareImpl(this.userRepository);
  }

}
