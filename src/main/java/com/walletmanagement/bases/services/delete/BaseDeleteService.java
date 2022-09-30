package com.walletmanagement.bases.services.delete;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseDeleteService<E extends BaseEntity, R extends JpaRepository<E, UUID>>
    implements IBaseDeleteService {

  protected abstract R getRepository();

  protected BaseDeleteService() {
  }

  @Override
  public void execute(UUID id) {
    getRepository().deleteById(id);
  }

}
