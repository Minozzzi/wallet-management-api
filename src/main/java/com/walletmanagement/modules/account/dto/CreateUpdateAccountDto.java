package com.walletmanagement.modules.account.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.walletmanagement.entities.enums.AccountTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateAccountDto {

  @NotNull
  @NotBlank
  private String bankingCode;

  @NotNull
  @NotBlank
  private String description;

  @NotNull
  private AccountTypeEnum type;

  @NotNull
  private Boolean includeInDashboard;

}
