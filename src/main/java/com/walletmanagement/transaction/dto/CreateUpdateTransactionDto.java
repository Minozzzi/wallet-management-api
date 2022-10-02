package com.walletmanagement.transaction.dto;

import java.time.Instant;
import java.util.UUID;

import com.walletmanagement.entities.enums.TransactionTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateTransactionDto {

  private UUID accountId;
  private UUID categoryId;
  private Instant dueDate;
  private Instant paymentDate;
  private Double amount;
  private Double amountPaid;
  private String description;
  private TransactionTypeEnum type;

}
