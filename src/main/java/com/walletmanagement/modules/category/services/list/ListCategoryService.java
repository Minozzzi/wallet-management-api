package com.walletmanagement.modules.category.services.list;

import org.springframework.stereotype.Service;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.bases.services.list.BaseListService;
import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.modules.category.CategoryRepository;
import com.walletmanagement.modules.category.dto.ListCategoryDto;
import com.walletmanagement.modules.category.dto.ListCategoryResponseDto;

@Service
public class ListCategoryService extends BaseListService<CategoryEntity, ListCategoryDto, ListCategoryResponseDto>
    implements IListCategoryService {

  private final CategoryRepository categoryRepository;
  private final BaseSpecification<CategoryEntity, ListCategoryDto> baseSpecification;

  public ListCategoryService(CategoryRepository categoryRepository,
      BaseSpecification<CategoryEntity, ListCategoryDto> baseSpecification) {
    super(ListCategoryResponseDto.class);
    this.categoryRepository = categoryRepository;
    this.baseSpecification = baseSpecification;
  }

  @Override
  protected IBaseRepository<CategoryEntity> getRepository() {
    return categoryRepository;
  }

  @Override
  protected BaseSpecification<CategoryEntity, ListCategoryDto> getSpecification() {
    return baseSpecification;
  }

}
