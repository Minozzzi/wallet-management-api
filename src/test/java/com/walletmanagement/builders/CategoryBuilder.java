package com.walletmanagement.builders;

import com.github.javafaker.Faker;
import com.walletmanagement.modules.category.dto.CreateUpdateCategoryDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryBuilder {

  private final Faker faker;

  public CreateUpdateCategoryDto validCategory() {
    return CreateUpdateCategoryDto
        .builder()
        .name(faker.lorem().word())
        .build();
  }

  public CreateUpdateCategoryDto invalidWithoutNameCategory() {
    return CreateUpdateCategoryDto
        .builder()
        .build();
  }

  public CreateUpdateCategoryDto invalidNullNameCategory() {
    return CreateUpdateCategoryDto
        .builder()
        .name("")
        .build();
  }

}
