package com.walletmanagement.category.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.entities.CategoryEntity;

@Service
public record ListAllCategoryService(CategoryRepository categoryRepository) {
  
  public List<CategoryEntity> execute() {
    return categoryRepository.findAll();
  }

}
