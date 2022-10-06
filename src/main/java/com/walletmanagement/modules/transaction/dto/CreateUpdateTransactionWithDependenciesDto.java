package com.walletmanagement.modules.transaction.dto;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.entities.enums.TransactionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateUpdateTransactionWithDependenciesDto {

  @NotNull
  private AccountEntity account;

  @NotNull
  private CategoryEntity category;

  @NotNull
  @FutureOrPresent
  private Date dueDate;

  @NotNull
  @PastOrPresent
  private Date paymentDate;

  @NotNull
  private Double amount;

  @NotNull
  private Double amountPaid;

  private String description;

  @NotNull
  private TransactionTypeEnum type;

}
