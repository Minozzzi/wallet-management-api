package com.walletmanagement.shared.auditorAware;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.walletmanagement.entities.UserEntity;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {

  @Bean
  AuditorAware<UserEntity> auditorProvider() {
    return new AuditorAwareImpl();
  }

}
