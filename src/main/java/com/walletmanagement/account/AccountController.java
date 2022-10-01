package com.walletmanagement.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.account.dto.CreateAccountResponseDto;
import com.walletmanagement.account.dto.CreateUpdateAccountDto;
import com.walletmanagement.account.dto.ListAccountDto;
import com.walletmanagement.account.dto.ListAccountResponseDto;
import com.walletmanagement.account.dto.ListAllAccountResponseDto;
import com.walletmanagement.bases.controllers.BaseController;
import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;

@RestController
@RequestMapping("account")
public class AccountController extends
    BaseController<CreateUpdateAccountDto, CreateAccountResponseDto, ListAccountDto, ListAccountResponseDto, ListAllAccountResponseDto> {

  private final IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> createService;
  private final IBaseUpdateService<CreateUpdateAccountDto> updateService;
  private final IBaseListService<ListAccountDto, ListAccountResponseDto> listService;
  private final IBaseListAllService<ListAllAccountResponseDto> listAllService;
  private final IBaseDeleteService deleteService;

  public AccountController(IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> createService,
      IBaseUpdateService<CreateUpdateAccountDto> updateService,
      IBaseListService<ListAccountDto, ListAccountResponseDto> listService,
      IBaseListAllService<ListAllAccountResponseDto> listAllService, IBaseDeleteService deleteService) {
    this.createService = createService;
    this.updateService = updateService;
    this.listService = listService;
    this.listAllService = listAllService;
    this.deleteService = deleteService;
  }

  @Override
  protected IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> getCreateService() {
    return createService;
  }

  @Override
  protected IBaseUpdateService<CreateUpdateAccountDto> getUpdateService() {
    return updateService;
  }

  @Override
  protected IBaseListService<ListAccountDto, ListAccountResponseDto> getListService() {
    return listService;
  }

  @Override
  protected IBaseListAllService<ListAllAccountResponseDto> getListAllService() {
    return listAllService;
  }

  @Override
  protected IBaseDeleteService getDeleteService() {
    return deleteService;
  }

}
