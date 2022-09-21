package com.walletmanagement.category.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.shared.dto.PaginationAndFiltersDto;

@Service
public record ListCategoryService(CategoryRepository categoryRepository) {

  public Page<CategoryEntity> execute(PaginationAndFiltersDto query) {
    Pageable pagination = PageRequest.of(query.getPage(), query.getPerPage());
    return categoryRepository.findAll(pagination);
  }

}
