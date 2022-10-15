package com.walletmanagement.modules.transaction.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.entities.enums.TransactionTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListTransactionResponseDto {

  private UUID id;
  private AccountEntity account;
  private CategoryEntity category;
  private LocalDateTime dueDate;
  private LocalDateTime paymentDate;
  private Double amount;
  private Double amountPaid;
  private String description;
  private TransactionTypeEnum type;

}
