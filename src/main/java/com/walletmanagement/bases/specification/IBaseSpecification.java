package com.walletmanagement.bases.specification;

import org.springframework.data.jpa.domain.Specification;

import com.walletmanagement.entities.base.BaseEntity;

public interface IBaseSpecification<E extends BaseEntity> {

  public Specification<E> entityAttributeContains(String attribute, String value);

  public <T> Specification<E> entityAttributeContains(String attribute, T value);

}
