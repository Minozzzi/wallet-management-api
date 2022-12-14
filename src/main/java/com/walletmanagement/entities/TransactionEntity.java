package com.walletmanagement.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.walletmanagement.entities.base.BaseEntity;
import com.walletmanagement.entities.enums.TransactionTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "transaction")
public class TransactionEntity extends BaseEntity {

  @ManyToOne()
  @JoinColumn(name = "account_id")
  private AccountEntity account;

  @ManyToOne()
  @JoinColumn(name = "category_id")
  private CategoryEntity category;

  @Column
  private LocalDateTime dueDate;

  @Column
  private LocalDateTime paymentDate;

  @Column
  private Double amount;

  @Column
  private Double amountPaid;

  @Column()
  private String description;

  @Column()
  private TransactionTypeEnum type;

}
