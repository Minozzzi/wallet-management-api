package com.walletmanagement.category.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.create.BaseCreateService;
import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.entities.CategoryEntity;

@Service
public class CreateCategoryService
    extends BaseCreateService<CategoryEntity, CreateUpdateCategoryDto, CreateCategoryResponseDto, UUID>
    implements ICreateCategoryService {

  private final CategoryRepository categoryRepository;

  public CreateCategoryService(CategoryRepository categoryRepository) {
    super(CategoryEntity.class, CreateCategoryResponseDto.class);
    this.categoryRepository = categoryRepository;
  }

  @Override
  protected JpaRepository<CategoryEntity, UUID> getRepository() {
    return categoryRepository;
  }

}
