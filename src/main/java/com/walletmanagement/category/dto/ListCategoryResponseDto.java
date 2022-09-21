package com.walletmanagement.category.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListCategoryResponseDto {
  
  private UUID id;
  private String name;

}
