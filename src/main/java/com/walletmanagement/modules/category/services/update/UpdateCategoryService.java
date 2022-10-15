package com.walletmanagement.modules.category.services.update;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.update.BaseUpdateService;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.modules.category.CategoryRepository;
import com.walletmanagement.modules.category.dto.CreateUpdateCategoryDto;

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
