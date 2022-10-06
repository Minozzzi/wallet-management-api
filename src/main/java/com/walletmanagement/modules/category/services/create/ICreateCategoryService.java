package com.walletmanagement.modules.category.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.modules.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.modules.category.dto.CreateUpdateCategoryDto;

public interface ICreateCategoryService
    extends IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> {
}
