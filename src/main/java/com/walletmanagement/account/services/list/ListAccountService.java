package com.walletmanagement.account.services.list;

import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.account.dto.ListAccountDto;
import com.walletmanagement.account.dto.ListAccountResponseDto;
import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.bases.services.list.BaseListService;
import com.walletmanagement.bases.specification.BaseSpecification;
import com.walletmanagement.entities.AccountEntity;

@Service
public class ListAccountService extends BaseListService<AccountEntity, ListAccountDto, ListAccountResponseDto>
    implements IListAccountService {

  private final AccountRepository accountRepository;
  private final BaseSpecification<AccountEntity, ListAccountDto> baseSpecification;

  public ListAccountService(AccountRepository accountRepository,
      BaseSpecification<AccountEntity, ListAccountDto> baseSpecification) {
    super(ListAccountResponseDto.class);
    this.accountRepository = accountRepository;
    this.baseSpecification = baseSpecification;
  }

  @Override
  protected IBaseRepository<AccountEntity> getRepository() {
    return accountRepository;
  }

  @Override
  protected BaseSpecification<AccountEntity, ListAccountDto> getSpecification() {
    return baseSpecification;
  }

}
