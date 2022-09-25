package com.walletmanagement.category;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.category.dto.ListAllCategoryResponseDto;
import com.walletmanagement.category.dto.ListCategoryDto;
import com.walletmanagement.category.dto.ListCategoryResponseDto;
import com.walletmanagement.category.services.CreateUpdateCategoryService;
import com.walletmanagement.category.services.DeleteCategoryService;
import com.walletmanagement.category.services.ListAllCategoryService;
import com.walletmanagement.category.services.ListCategoryService;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

@RestController
@RequestMapping("category")
public record CategoryController(
    ModelMapper mapper,
    CreateUpdateCategoryService createCategoryService,
    ListCategoryService listCategoryService,
    ListAllCategoryService listAllCategoryService,
    DeleteCategoryService deleteCategoryService) {

  @PostMapping
  public ResponseEntity<CreateCategoryResponseDto> create(@Valid @RequestBody CreateUpdateCategoryDto dto) {
    CategoryEntity category = mapper.map(dto, CategoryEntity.class);
    CategoryEntity createdCategory = createCategoryService.execute(category);
    CreateCategoryResponseDto response = mapper.map(createdCategory, CreateCategoryResponseDto.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PatchMapping("{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody CreateUpdateCategoryDto dto) {
    CategoryEntity category = mapper.map(dto, CategoryEntity.class);
    createCategoryService.execute(category);

    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<PaginationResponseDto<ListCategoryResponseDto>> list(PaginationDto pagination,
      ListCategoryDto filters) {
    Page<CategoryEntity> paginatedCategories = listCategoryService.execute(pagination, filters);
    List<ListCategoryResponseDto> categories = paginatedCategories.getContent().stream()
        .map(category -> mapper.map(category, ListCategoryResponseDto.class))
        .toList();

    PaginationResponseDto<ListCategoryResponseDto> response = new PaginationResponseDto<>(
        categories, paginatedCategories.getTotalPages());
    return ResponseEntity.ok(response);
  }

  @GetMapping("all")
  public ResponseEntity<List<ListAllCategoryResponseDto>> listAll() {
    List<CategoryEntity> categories = listAllCategoryService.execute();
    List<ListAllCategoryResponseDto> response = categories.stream()
        .map(category -> mapper.map(category, ListAllCategoryResponseDto.class))
        .toList();

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    deleteCategoryService.execute(id);
    return ResponseEntity.noContent().build();
  }

}
