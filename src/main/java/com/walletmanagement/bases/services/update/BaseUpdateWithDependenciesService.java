package com.walletmanagement.bases.services.update;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.walletmanagement.entities.base.BaseEntity;

public abstract class BaseUpdateWithDependenciesService<E extends BaseEntity, P, D>
    implements IBaseUpdateService<D> {

  protected abstract JpaRepository<E, UUID> getRepository();

  protected abstract P setDependencies(D dto);

  private final Class<E> typeEntityClass;
  private final ModelMapper mapper = new ModelMapper();

  protected BaseUpdateWithDependenciesService(Class<E> typeEntityClass) {
    this.typeEntityClass = typeEntityClass;
  }

  @Override
  public void execute(UUID id, D dto) {
    Optional<E> optionalResource = getRepository().findById(id);

    if (optionalResource.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource " + id + " not found");
    }

    P dtoWithDependencies = setDependencies(dto);
    E resource = mapper.map(dtoWithDependencies, typeEntityClass);
    resource.setId(id);

    getRepository().save(resource);
  }

}
