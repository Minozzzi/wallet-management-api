package com.walletmanagement.bases.services.create;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseCreateWithDependenciesService<E extends BaseEntity, P, D, R, I>
    implements IBaseCreateService<D, R> {

  protected abstract JpaRepository<E, I> getRepository();

  protected abstract P setDependencies(D dto);

  private final Class<E> typeEntityClass;
  private final Class<R> typeResponseDtoClass;
  private final ModelMapper mapper = new ModelMapper();

  protected BaseCreateWithDependenciesService(Class<E> typeEntityClass, Class<R> typeResponseDtoClass) {
    this.typeEntityClass = typeEntityClass;
    this.typeResponseDtoClass = typeResponseDtoClass;
  }

  @Override
  public R execute(D dto) {
    P dtoWithDependencies = setDependencies(dto);
    E resource = mapper.map(dtoWithDependencies, this.typeEntityClass);
    E createdResource = getRepository().save(resource);
    return mapper.map(createdResource, this.typeResponseDtoClass);
  }

}
