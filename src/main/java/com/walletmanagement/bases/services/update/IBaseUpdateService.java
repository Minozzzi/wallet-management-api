package com.walletmanagement.bases.services.update;

import java.util.UUID;

public interface IBaseUpdateService<D> {

  public void execute(UUID id, D dto);

}
