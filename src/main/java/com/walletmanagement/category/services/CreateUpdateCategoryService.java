package com.walletmanagement.category.services;

import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.entities.CategoryEntity;

@Service
public record CreateUpdateCategoryService(CategoryRepository categoryRepository) {

  public CategoryEntity execute(CategoryEntity category) {
    return categoryRepository.save(category);
  }

}
