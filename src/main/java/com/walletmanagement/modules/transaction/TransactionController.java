package com.walletmanagement.modules.transaction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.bases.controllers.BaseController;
import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.bases.services.delete.IBaseDeleteService;
import com.walletmanagement.bases.services.list.IBaseListService;
import com.walletmanagement.bases.services.listAll.IBaseListAllService;
import com.walletmanagement.bases.services.update.IBaseUpdateService;
import com.walletmanagement.modules.transaction.dto.CreateTransactionResponseDto;
import com.walletmanagement.modules.transaction.dto.CreateUpdateTransactionDto;
import com.walletmanagement.modules.transaction.dto.ListAllTransactionResponseDto;
import com.walletmanagement.modules.transaction.dto.ListTransactionDto;
import com.walletmanagement.modules.transaction.dto.ListTransactionResponseDto;

@RestController
@RequestMapping("transaction")
public class TransactionController extends
    BaseController<CreateUpdateTransactionDto, CreateTransactionResponseDto, ListTransactionDto, ListTransactionResponseDto, ListAllTransactionResponseDto> {

  private final IBaseCreateService<CreateUpdateTransactionDto, CreateTransactionResponseDto> createTransactionService;
  private final IBaseUpdateService<CreateUpdateTransactionDto> updateTransactionService;
  private final IBaseListService<ListTransactionDto, ListTransactionResponseDto> listTransactionService;
  private final IBaseListAllService<ListAllTransactionResponseDto> listAllTransactionService;
  private final IBaseDeleteService deleteTransactionService;

  public TransactionController(
      IBaseCreateService<CreateUpdateTransactionDto, CreateTransactionResponseDto> createTransactionService,
      IBaseUpdateService<CreateUpdateTransactionDto> updateTransactionService,
      IBaseListService<ListTransactionDto, ListTransactionResponseDto> listTransactionService,
      IBaseListAllService<ListAllTransactionResponseDto> listAllTransactionService,
      IBaseDeleteService deleteTransactionService) {
    this.createTransactionService = createTransactionService;
    this.updateTransactionService = updateTransactionService;
    this.listTransactionService = listTransactionService;
    this.listAllTransactionService = listAllTransactionService;
    this.deleteTransactionService = deleteTransactionService;
  }

  @Override
  protected IBaseCreateService<CreateUpdateTransactionDto, CreateTransactionResponseDto> getCreateService() {
    return createTransactionService;
  }

  @Override
  protected IBaseUpdateService<CreateUpdateTransactionDto> getUpdateService() {
    return updateTransactionService;
  }

  @Override
  protected IBaseListService<ListTransactionDto, ListTransactionResponseDto> getListService() {
    return listTransactionService;
  }

  @Override
  protected IBaseListAllService<ListAllTransactionResponseDto> getListAllService() {
    return listAllTransactionService;
  }

  @Override
  protected IBaseDeleteService getDeleteService() {
    return deleteTransactionService;
  }

}
