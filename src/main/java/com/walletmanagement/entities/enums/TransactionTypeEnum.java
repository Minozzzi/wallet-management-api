package com.walletmanagement.entities.enums;

public enum TransactionTypeEnum {

  INCOME("income"),
  EXPENSE("expense"),
  TRANSFER("transfer");

  private String value;

  private TransactionTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
