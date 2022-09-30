package com.walletmanagement.bases.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T, U> {

  private static final String WILDCARD = "%";

  public abstract Specification<T> getFilter(U request);

  public Specification<T> entityAttributeContains(String attribute, String value) {
    return (root, query, cb) -> {
      if (value == null) {
        return null;
      }

      return cb.like(
          cb.lower(root.get(attribute)),
          containsLowerCase(value));
    };
  }

  private String containsLowerCase(String searchField) {
    return WILDCARD + searchField.toLowerCase() + WILDCARD;
  }

}