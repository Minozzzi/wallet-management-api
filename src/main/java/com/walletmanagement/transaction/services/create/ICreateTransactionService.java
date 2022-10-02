package com.walletmanagement.transaction.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.transaction.dto.CreateTransactionResponseDto;
import com.walletmanagement.transaction.dto.CreateUpdateTransactionDto;

public interface ICreateTransactionService
    extends IBaseCreateService<CreateUpdateTransactionDto, CreateTransactionResponseDto> {
}
