package com.walletmanagement.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationAndFiltersDto {

  private int page;

  private int perPage;

}
