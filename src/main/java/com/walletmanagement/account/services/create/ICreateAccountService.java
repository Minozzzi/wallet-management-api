package com.walletmanagement.account.services.create;

import com.walletmanagement.account.dto.CreateAccountResponseDto;
import com.walletmanagement.account.dto.CreateUpdateAccountDto;
import com.walletmanagement.bases.services.create.IBaseCreateService;

public interface ICreateAccountService
    extends IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> {
}
