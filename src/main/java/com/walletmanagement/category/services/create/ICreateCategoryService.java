package com.walletmanagement.category.services.create;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;

public interface ICreateCategoryService
    extends IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> {
}
