package com.walletmanagement.category.services.delete;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.delete.BaseDeleteService;
import com.walletmanagement.category.CategoryRepository;
import com.walletmanagement.entities.CategoryEntity;

@Service
public class DeleteCategoryService extends BaseDeleteService<CategoryEntity> implements IDeleteCategoryService {

  private final CategoryRepository categoryRepository;

  public DeleteCategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  protected JpaRepository<CategoryEntity, UUID> getRepository() {
    return categoryRepository;
  }

}
