package com.walletmanagement.searchers;

import java.util.Optional;
import java.util.UUID;

import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.modules.category.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategorySearcher {

  private final CategoryRepository categoryRepository;

  public Optional<CategoryEntity> findById(UUID id) {
    return categoryRepository.findById(id);
  }

}
