package com.walletmanagement.modules.category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.bases.controllers.BaseController;
import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;
import com.walletmanagement.modules.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.modules.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.modules.category.dto.ListAllCategoryResponseDto;
import com.walletmanagement.modules.category.dto.ListCategoryDto;
import com.walletmanagement.modules.category.dto.ListCategoryResponseDto;

@RestController
@RequestMapping("category")
public class CategoryController extends
    BaseController<CreateUpdateCategoryDto, CreateCategoryResponseDto, ListCategoryDto, ListCategoryResponseDto, ListAllCategoryResponseDto> {

  private final IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> createCategoryService;
  private final IBaseUpdateService<CreateUpdateCategoryDto> updateCategoryService;
  private final IBaseListService<ListCategoryDto, ListCategoryResponseDto> listCategoryService;
  private final IBaseListAllService<ListAllCategoryResponseDto> listAllCategoryService;
  private final IBaseDeleteService deleteCategoryService;

  public CategoryController(IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> createCategoryService,
      IBaseUpdateService<CreateUpdateCategoryDto> updateCategoryService,
      IBaseListService<ListCategoryDto, ListCategoryResponseDto> listCategoryService,
      IBaseListAllService<ListAllCategoryResponseDto> listAllCategoryService, IBaseDeleteService deleteCategoryService) {
    this.createCategoryService = createCategoryService;
    this.updateCategoryService = updateCategoryService;
    this.listCategoryService = listCategoryService;
    this.listAllCategoryService = listAllCategoryService;
    this.deleteCategoryService = deleteCategoryService;
  }

  @Override
  protected IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> getCreateService() {
    return createCategoryService;
  }

  @Override
  protected IBaseUpdateService<CreateUpdateCategoryDto> getUpdateService() {
    return updateCategoryService;
  }

  @Override
  protected IBaseListService<ListCategoryDto, ListCategoryResponseDto> getListService() {
    return listCategoryService;
  }

  @Override
  protected IBaseListAllService<ListAllCategoryResponseDto> getListAllService() {
    return listAllCategoryService;
  }

  @Override
  protected IBaseDeleteService getDeleteService() {
    return deleteCategoryService;
  }

}
