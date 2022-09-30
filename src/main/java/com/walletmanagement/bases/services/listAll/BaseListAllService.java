package com.walletmanagement.bases.services.listAll;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseListAllService<E extends BaseEntity, R> implements IBaseListAllService<R> {

  protected abstract JpaRepository<E, UUID> getRepository();

  private final Class<R> typeResponseDtoClass;
  private final ModelMapper mapper = new ModelMapper();

  protected BaseListAllService(Class<R> typeResponseDtoClass) {
    this.typeResponseDtoClass = typeResponseDtoClass;
  }

  @Override
  public List<R> execute() {
    return getRepository().findAll().stream()
        .map(category -> mapper.map(category, typeResponseDtoClass))
        .toList();
  }

}
