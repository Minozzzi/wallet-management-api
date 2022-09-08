package com.walletmanagement.category;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.category.dto.CreateCategoryDto;
import com.walletmanagement.category.services.CreateCategoryService;
import com.walletmanagement.entities.CategoryEntity;

@RestController
@RequestMapping("category")
public record CategoryController(CreateCategoryService createCategoryService) {

  @PostMapping
  public ResponseEntity<CategoryEntity> create(@Valid @RequestBody CreateCategoryDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(createCategoryService.execute(dto.toEntity()));
  }

}
