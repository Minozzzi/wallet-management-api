package com.walletmanagement.category;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.category.dto.CreateCategoryDto;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.services.CreateCategoryService;
import com.walletmanagement.entities.CategoryEntity;

@RestController
@RequestMapping("category")
public record CategoryController(CreateCategoryService createCategoryService, ModelMapper mapper) {

  @PostMapping
  public ResponseEntity<CreateCategoryResponseDto> create(@Valid @RequestBody CreateCategoryDto dto) {
    CategoryEntity category = mapper.map(dto, CategoryEntity.class);
    CategoryEntity createdCategory = createCategoryService.execute(category);
    CreateCategoryResponseDto response = mapper.map(createdCategory, CreateCategoryResponseDto.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}
