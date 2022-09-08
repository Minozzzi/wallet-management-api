package com.walletmanagement.category.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.walletmanagement.entities.CategoryEntity;

public record CreateCategoryDto(@NotNull @NotBlank String name) {

  public CategoryEntity toEntity() {
    return CategoryEntity.builder().name(this.name).build();
  }

}
