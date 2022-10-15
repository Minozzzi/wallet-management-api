package com.walletmanagement.modules.category.services.listAll;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.listAll.BaseListAllService;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.modules.category.CategoryRepository;
import com.walletmanagement.modules.category.dto.ListAllCategoryResponseDto;

@Service
public class ListAllCategoryService extends BaseListAllService<CategoryEntity, ListAllCategoryResponseDto>
    implements IListAllCategoryService {

  private final CategoryRepository categoryRepository;

  public ListAllCategoryService(CategoryRepository categoryRepository) {
    super(ListAllCategoryResponseDto.class);
    this.categoryRepository = categoryRepository;
  }

  @Override
  protected JpaRepository<CategoryEntity, UUID> getRepository() {
    return categoryRepository;
  }

}
