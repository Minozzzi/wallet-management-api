package com.walletmanagement.entities.enums;

public enum AccountTypeEnum {

  CHECKING_ACCOUNT("checking_account"),
  WALLET("wallet"),
  SAVING_ACCOUNT("saving_account"),
  OTHER("other");

  private String value;

  private AccountTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
