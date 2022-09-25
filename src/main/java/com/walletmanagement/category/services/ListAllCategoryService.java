package com.walletmanagement.category.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.ListAllCategoryResponseDto;

@Service
public record ListAllCategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {

  public List<ListAllCategoryResponseDto> execute() {
    return categoryRepository.findAll().stream()
        .map(category -> mapper.map(category, ListAllCategoryResponseDto.class))
        .toList();
  }

}
