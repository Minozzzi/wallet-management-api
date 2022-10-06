package com.walletmanagement.modules.category.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateCategoryDto {

  @NotNull
  @NotBlank
  private String name;

}
