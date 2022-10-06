package com.walletmanagement.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.walletmanagement.entities.base.BaseEntity;
import com.walletmanagement.entities.enums.AccountTypeEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "account")
public class AccountEntity extends BaseEntity {

  @Column
  private String bankingCode;

  @Column
  private String description;

  @Column
  private AccountTypeEnum type;

  @Column
  private Boolean includeInDashboard;

  public AccountEntity(UUID id) {
    super(id);
  }

}
