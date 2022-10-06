package com.walletmanagement.modules.transaction.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.modules.transaction.dto.CreateTransactionResponseDto;
import com.walletmanagement.modules.transaction.dto.CreateUpdateTransactionDto;

public interface ICreateTransactionService
    extends IBaseCreateService<CreateUpdateTransactionDto, CreateTransactionResponseDto> {
}
