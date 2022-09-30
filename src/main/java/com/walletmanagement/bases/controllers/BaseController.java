package com.walletmanagement.bases.controllers;

import com.walletmanagement.bases.services.IBaseCreateService;

public abstract class BaseController<D, R> {

  protected abstract IBaseCreateService<D, R> getCreateService();

}
