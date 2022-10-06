package com.walletmanagement.modules.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.bases.controllers.BaseController;
import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;
import com.walletmanagement.modules.account.dto.CreateAccountResponseDto;
import com.walletmanagement.modules.account.dto.CreateUpdateAccountDto;
import com.walletmanagement.modules.account.dto.ListAccountDto;
import com.walletmanagement.modules.account.dto.ListAccountResponseDto;
import com.walletmanagement.modules.account.dto.ListAllAccountResponseDto;

@RestController
@RequestMapping("account")
public class AccountController extends
    BaseController<CreateUpdateAccountDto, CreateAccountResponseDto, ListAccountDto, ListAccountResponseDto, ListAllAccountResponseDto> {

  private final IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> createAccountService;
  private final IBaseUpdateService<CreateUpdateAccountDto> updateAccountService;
  private final IBaseListService<ListAccountDto, ListAccountResponseDto> listAccountService;
  private final IBaseListAllService<ListAllAccountResponseDto> listAllAccountService;
  private final IBaseDeleteService deleteAccountService;

  public AccountController(IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> createAccountService,
      IBaseUpdateService<CreateUpdateAccountDto> updateAccountService,
      IBaseListService<ListAccountDto, ListAccountResponseDto> listAccountService,
      IBaseListAllService<ListAllAccountResponseDto> listAllAccountService, IBaseDeleteService deleteAccountService) {
    this.createAccountService = createAccountService;
    this.updateAccountService = updateAccountService;
    this.listAccountService = listAccountService;
    this.listAllAccountService = listAllAccountService;
    this.deleteAccountService = deleteAccountService;
  }

  @Override
  protected IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> getCreateService() {
    return createAccountService;
  }

  @Override
  protected IBaseUpdateService<CreateUpdateAccountDto> getUpdateService() {
    return updateAccountService;
  }

  @Override
  protected IBaseListService<ListAccountDto, ListAccountResponseDto> getListService() {
    return listAccountService;
  }

  @Override
  protected IBaseListAllService<ListAllAccountResponseDto> getListAllService() {
    return listAllAccountService;
  }

  @Override
  protected IBaseDeleteService getDeleteService() {
    return deleteAccountService;
  }

}
