package com.walletmanagement.account.dto;

import com.walletmanagement.entities.enums.AccountTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListAccountDto {

  private String bankingCode;
  private String description;
  private AccountTypeEnum type;
  private Boolean includeInDashboard;

}
