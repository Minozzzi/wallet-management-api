package com.walletmanagement.account.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateAccountResponseDto {

  private UUID id;
  private String bankingCode;
  private String description;
  private String type;
  private Boolean includeInDashboard;

}
