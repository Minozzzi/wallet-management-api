package com.walletmanagement.bases.services;

public interface IBaseCreateService<D, R> {

  R execute(D dto);

}
