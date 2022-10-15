package com.walletmanagement.modules.category.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListAllCategoryResponseDto {

  private UUID id;
  private String name;

}
