package com.walletmanagement.bases.services.update;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseUpdateService<E extends BaseEntity, D> implements IBaseUpdateService<D> {

  protected abstract JpaRepository<E, UUID> getRepository();

  private final Class<E> typeEntityClass;
  private final ModelMapper mapper = new ModelMapper();

  protected BaseUpdateService(Class<E> typeEntityClass) {
    this.typeEntityClass = typeEntityClass;
  }

  @Override
  public void execute(UUID id, D dto) {
    Optional<E> optionalResource = getRepository().findById(id);

    if (optionalResource.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource " + id + " not found");
    }

    E resource = mapper.map(dto, typeEntityClass);
    resource.setId(id);

    getRepository().save(resource);
  }

}
