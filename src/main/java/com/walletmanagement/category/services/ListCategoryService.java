package com.walletmanagement.category.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.ListCategoryDto;
import com.walletmanagement.category.dto.ListCategoryResponseDto;
import com.walletmanagement.category.specifications.ListCategorySpecification;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

@Service
public record ListCategoryService(CategoryRepository categoryRepository,
    ListCategorySpecification listCategorySpecification, ModelMapper mapper) {

  public PaginationResponseDto<ListCategoryResponseDto> execute(PaginationDto pagination, ListCategoryDto filters) {
    Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getPerPage(),
        Boolean.TRUE.equals(pagination.getIsAsc()) ? Sort.Direction.ASC : Sort.Direction.DESC,
        pagination.getSortField());
    Specification<CategoryEntity> specification = listCategorySpecification.getFilter(filters);

    Page<CategoryEntity> paginatedCategories = categoryRepository.findAll(specification, pageable);

    return new PaginationResponseDto<>(
        paginatedCategories.getContent().stream()
            .map(category -> mapper.map(category, ListCategoryResponseDto.class))
            .toList(),
        paginatedCategories.getTotalPages());
  }

}
