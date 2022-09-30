package com.walletmanagement.category.services;

import com.walletmanagement.bases.services.IBaseCreateService;
import com.walletmanagement.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.category.dto.CreateUpdateCategoryDto;

public interface ICreateCategoryService
    extends IBaseCreateService<CreateUpdateCategoryDto, CreateCategoryResponseDto> {
}
