package com.walletmanagement.transaction.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListAllTransactionResponseDto {

  private UUID id;
  private String description;

}
