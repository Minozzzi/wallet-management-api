package com.walletmanagement.user.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.user.dto.CreateUpdateUserDto;
import com.walletmanagement.user.dto.CreateUserResponseDto;

public interface ICreateUserService extends IBaseCreateService<CreateUpdateUserDto, CreateUserResponseDto> {
}
