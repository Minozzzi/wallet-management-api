package com.walletmanagement.modules.user.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;
import com.walletmanagement.modules.user.dto.CreateUserResponseDto;

public interface ICreateUserService extends IBaseCreateService<CreateUpdateUserDto, CreateUserResponseDto> {
}
