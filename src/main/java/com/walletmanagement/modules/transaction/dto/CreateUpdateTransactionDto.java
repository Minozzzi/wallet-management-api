package com.walletmanagement.modules.transaction.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.walletmanagement.entities.enums.TransactionTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateTransactionDto {

  @NotNull
  private UUID accountId;

  @NotNull
  private UUID categoryId;

  @NotNull
  @FutureOrPresent
  private LocalDateTime dueDate;

  @NotNull
  @PastOrPresent
  private LocalDateTime paymentDate;

  @NotNull
  private Double amount;

  @NotNull
  private Double amountPaid;

  private String description;

  @NotNull
  private TransactionTypeEnum type;

}
