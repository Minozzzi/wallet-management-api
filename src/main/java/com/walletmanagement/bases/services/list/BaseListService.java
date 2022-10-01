package com.walletmanagement.bases.services.list;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.base.BaseEntity;
import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

public abstract class BaseListService<E extends BaseEntity, D, R> implements IBaseListService<D, R> {

  protected abstract IBaseRepository<E> getRepository();

  protected abstract BaseSpecification<E, D> getSpecification();

  private final Class<R> typeResponseDtoClass;
  private final ModelMapper mapper = new ModelMapper();

  protected BaseListService(Class<R> typeResponseDtoClass) {
    this.typeResponseDtoClass = typeResponseDtoClass;
  }

  @Override
  public PaginationResponseDto<R> execute(PaginationDto pagination, D filters) {
    Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getPerPage());

    if (pagination.getSortField() != null) {
      pageable = PageRequest.of(pagination.getPage(), pagination.getPerPage(),
          Boolean.TRUE.equals(pagination.getIsAsc()) ? Sort.by(pagination.getSortField()).ascending()
              : Sort.by(pagination.getSortField()).descending());
    }

    Specification<E> specification = getSpecification().getFilter(filters);

    Page<E> paginatedCategories = getRepository().findAll(specification, pageable);

    return new PaginationResponseDto<>(
        paginatedCategories.getContent().stream()
            .map(category -> mapper.map(category, typeResponseDtoClass))
            .toList(),
        paginatedCategories.getTotalPages());
  }

}
