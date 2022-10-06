package com.walletmanagement.modules.account.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListAllAccountResponseDto {

  private UUID id;
  private String bankingCode;
  private String description;

}
