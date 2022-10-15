package com.walletmanagement.modules.account.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.modules.account.dto.CreateAccountResponseDto;
import com.walletmanagement.modules.account.dto.CreateUpdateAccountDto;

public interface ICreateAccountService
    extends IBaseCreateService<CreateUpdateAccountDto, CreateAccountResponseDto> {
}
