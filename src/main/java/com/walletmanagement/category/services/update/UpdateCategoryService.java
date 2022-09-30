package com.walletmanagement.category.services.update;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.update.BaseUpdateService;
import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.entities.CategoryEntity;

@Service
public class UpdateCategoryService
    extends BaseUpdateService<CategoryEntity, CreateUpdateCategoryDto>
    implements IUpdateCategoryService {

  private final CategoryRepository categoryRepository;

  public UpdateCategoryService(CategoryRepository categoryRepository) {
    super(CategoryEntity.class);
    this.categoryRepository = categoryRepository;
  }

  @Override
  protected JpaRepository<CategoryEntity, UUID> getRepository() {
    return categoryRepository;
  }

}
