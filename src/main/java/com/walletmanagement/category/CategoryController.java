package com.walletmanagement.category;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.category.dto.CreateCategoryDto;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.ListAllCategoryResponseDto;
import com.walletmanagement.category.services.CreateCategoryService;
import com.walletmanagement.category.services.DeleteCategoryService;
import com.walletmanagement.category.services.ListAllCategoryService;
import com.walletmanagement.entities.CategoryEntity;

@RestController
@RequestMapping("category")
public record CategoryController(
    ModelMapper mapper,
    CreateCategoryService createCategoryService,
    DeleteCategoryService deleteCategoryService,
    ListAllCategoryService listAllCategoryService) {

  @PostMapping
  public ResponseEntity<CreateCategoryResponseDto> create(@Valid @RequestBody CreateCategoryDto dto) {
    CategoryEntity category = mapper.map(dto, CategoryEntity.class);
    CategoryEntity createdCategory = createCategoryService.execute(category);
    CreateCategoryResponseDto response = mapper.map(createdCategory, CreateCategoryResponseDto.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    deleteCategoryService.execute(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("all")
  public ResponseEntity<List<ListAllCategoryResponseDto>> listAll() {
    List<CategoryEntity> categories = listAllCategoryService.execute();
    List<ListAllCategoryResponseDto> response = categories.stream()
        .map(category -> mapper.map(category, ListAllCategoryResponseDto.class))
        .toList();

    return ResponseEntity.ok(response);
  }

}
