package com.walletmanagement.category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.bases.controllers.BaseController;
import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.category.dto.ListAllCategoryResponseDto;
import com.walletmanagement.category.dto.ListCategoryDto;
import com.walletmanagement.category.dto.ListCategoryResponseDto;

@RestController
@RequestMapping("category")
public class CategoryController extends
    BaseController<CreateUpdateCategoryDto, CreateCategoryResponseDto, ListCategoryDto, ListCategoryResponseDto, ListAllCategoryResponseDto> {

  private final IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> createService;
  private final IBaseUpdateService<CreateUpdateCategoryDto> updateService;
  private final IBaseListService<ListCategoryDto, ListCategoryResponseDto> listService;
  private final IBaseListAllService<ListAllCategoryResponseDto> listAllService;
  private final IBaseDeleteService deleteService;

  public CategoryController(IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> createService,
      IBaseUpdateService<CreateUpdateCategoryDto> updateService,
      IBaseListService<ListCategoryDto, ListCategoryResponseDto> listService,
      IBaseListAllService<ListAllCategoryResponseDto> listAllService, IBaseDeleteService deleteService) {
    this.createService = createService;
    this.updateService = updateService;
    this.listService = listService;
    this.listAllService = listAllService;
    this.deleteService = deleteService;
  }

  @Override
  protected IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> getCreateService() {
    return createService;
  }

  @Override
  protected IBaseUpdateService<CreateUpdateCategoryDto> getUpdateService() {
    return updateService;
  }

  @Override
  protected IBaseListService<ListCategoryDto, ListCategoryResponseDto> getListService() {
    return listService;
  }

  @Override
  protected IBaseListAllService<ListAllCategoryResponseDto> getListAllService() {
    return listAllService;
  }

  @Override
  protected IBaseDeleteService getDeleteService() {
    return deleteService;
  }

}
