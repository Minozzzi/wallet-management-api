package com.walletmanagement.shared.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationResponseDto<R extends Object> {

  private List<R> results;
  private int totalPages;

}
