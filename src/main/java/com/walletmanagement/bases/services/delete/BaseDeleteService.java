package com.walletmanagement.bases.services.delete;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseDeleteService<E extends BaseEntity>
    implements IBaseDeleteService {

  protected abstract JpaRepository<E, UUID> getRepository();

  protected BaseDeleteService() {
  }

  @Override
  public void execute(UUID id) {
    getRepository().deleteById(id);
  }

}
