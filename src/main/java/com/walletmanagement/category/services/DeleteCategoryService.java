package com.walletmanagement.category.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;

@Service
public record DeleteCategoryService(CategoryRepository categoryRepository) {

  public void execute(UUID id) {
    categoryRepository.deleteById(id);
  }

}
