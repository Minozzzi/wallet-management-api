package com.walletmanagement.category;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

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
import com.walletmanagement.category.services.CreateCategoryService;
import com.walletmanagement.category.services.DeleteCategoryService;
import com.walletmanagement.category.services.ListAllCategoryService;
import com.walletmanagement.category.services.ListCategoryService;
import com.walletmanagement.category.services.UpdateCategoryService;
import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

@RestController
@RequestMapping("category")
public record CategoryController(
    CreateCategoryService createUpdateCategoryService,
    UpdateCategoryService updateCategoryService,
    ListCategoryService listCategoryService,
    ListAllCategoryService listAllCategoryService,
    DeleteCategoryService deleteCategoryService) {

  @PostMapping
  public ResponseEntity<CreateCategoryResponseDto> create(@Valid @RequestBody CreateUpdateCategoryDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(createUpdateCategoryService.execute(dto));
  }

  @PatchMapping("{id}")
  public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody CreateUpdateCategoryDto dto) {
    updateCategoryService.execute(id, dto);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<PaginationResponseDto<ListCategoryResponseDto>> list(PaginationDto pagination,
      ListCategoryDto filters) {
    // TODO @Minozzzi 2022-09-26: Refactor this to use the -1 generic setter
    pagination.setPage(pagination.getPage() - 1);
    return ResponseEntity.ok(listCategoryService.execute(pagination, filters));
  }

  @GetMapping("all")
  public ResponseEntity<List<ListAllCategoryResponseDto>> listAll() {
    return ResponseEntity.ok(listAllCategoryService.execute());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    deleteCategoryService.execute(id);
    return ResponseEntity.noContent().build();
  }

}
