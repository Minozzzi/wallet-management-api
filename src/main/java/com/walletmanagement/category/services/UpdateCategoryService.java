package com.walletmanagement.category.services;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.entities.CategoryEntity;

@Service
public record UpdateCategoryService(
    CategoryRepository categoryRepository, ModelMapper mapper) {

  public void execute(UUID id, CreateUpdateCategoryDto dtoCategory) {
    Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);

    if (optionalCategory.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category " + id + " not found");
    }

    CategoryEntity category = mapper.map(dtoCategory, CategoryEntity.class);
    category.setId(id);

    categoryRepository.save(category);
  }

}
