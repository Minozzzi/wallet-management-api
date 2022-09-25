package com.walletmanagement.category.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.entities.CategoryEntity;

@Service
public record CreateCategoryService(
    CategoryRepository categoryRepository, ModelMapper mapper) {

  public CreateCategoryResponseDto execute(CreateUpdateCategoryDto dtoCategory) {
    CategoryEntity category = mapper.map(dtoCategory, CategoryEntity.class);
    CategoryEntity createdCategory = categoryRepository.save(category);
    return mapper.map(createdCategory, CreateCategoryResponseDto.class);
  }

}
