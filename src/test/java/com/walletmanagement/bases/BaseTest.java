package com.walletmanagement.bases;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.github.javafaker.Faker;
import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseTest<E extends BaseEntity, R extends IBaseRepository<E>> {

  @Autowired
  protected R repository;

  @Autowired
  protected TestRestTemplate restTemplate;

  @Autowired
  protected Faker faker = new Faker();

  @BeforeEach()
  private void cleanup() {
    repository.deleteAll();
    restTemplate.getRestTemplate().getInterceptors().clear();
  }

}
