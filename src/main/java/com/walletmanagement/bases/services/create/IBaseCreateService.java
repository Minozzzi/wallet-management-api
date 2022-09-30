package com.walletmanagement.bases.services.create;

public interface IBaseCreateService<D, R> {

  R execute(D dto);

}
