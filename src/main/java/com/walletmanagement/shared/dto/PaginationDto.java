package com.walletmanagement.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {

  private int page;

  private int perPage;

  private Boolean isAsc;

  private String sortField;

  public PaginationDto(int page, int perPage, Boolean isAsc, String sortField) {
    // TODO @Minozzzi 2022-09-25: This is not working, it does not return -1 in the getter
    this.page = --page;
    this.perPage = perPage;
    this.isAsc = isAsc != null && isAsc;
    this.sortField = sortField != null ? sortField : "createdAt";
  }

}
