package com.walletmanagement.bases.specification;

import org.springframework.data.jpa.domain.Specification;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseSpecification<E extends BaseEntity, D> implements IBaseSpecification<E> {

  private static final String WILDCARD = "%";

  public abstract Specification<E> getFilter(D request);

  @Override
  public Specification<E> entityAttributeContains(String attribute, String value) {
    return (root, query, cb) -> {
      if (value == null) {
        return null;
      }

      return cb.like(
          cb.lower(root.get(attribute)),
          containsLowerCase(value));
    };
  }

  @Override 
  public Specification<E> entityAttributeContains(String attribute, Boolean value) {
    return (root, query, cb) -> {
      if (value == null) {
        return null;
      }

      return cb.equal(root.get(attribute), value);
    };
  }

  @Override
  public <T> Specification<E> entityAttributeContains(String attribute, T value) {
    return (root, query, cb) -> {
      if (value == null) {
        return null;
      }

      return cb.equal(root.get(attribute), value);
    };
  }

  private String containsLowerCase(String searchField) {
    return WILDCARD + searchField.toLowerCase() + WILDCARD;
  }

}