package com.walletmanagement.modules.category.specifications;

import static org.springframework.data.jpa.domain.Specification.where;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.modules.category.dto.ListCategoryDto;

@Component
public class ListCategorySpecification extends BaseSpecification<CategoryEntity, ListCategoryDto> {

  @Override
  public Specification<CategoryEntity> getFilter(ListCategoryDto filters) {
    return (root, query, cb) -> {
      query.distinct(true);
      return where(nameContains(filters.getName())).toPredicate(root, query, cb);
    };
  }

  private Specification<CategoryEntity> nameContains(String name) {
    return this.entityAttributeContains("name", name);
  }

}
