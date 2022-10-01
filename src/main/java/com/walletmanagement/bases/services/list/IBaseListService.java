package com.walletmanagement.bases.services.list;

import com.walletmanagement.shared.dto.PaginationDto;
import com.walletmanagement.shared.dto.PaginationResponseDto;

public interface IBaseListService<D, R> {

  public PaginationResponseDto<R> execute(PaginationDto pagination, D filters);

}
