package com.walletmanagement.account.services.listAll;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.account.dto.ListAllAccountResponseDto;
import com.walletmanagement.bases.services.listAll.BaseListAllService;
import com.walletmanagement.entities.AccountEntity;

@Service
public class ListAllAccountService extends BaseListAllService<AccountEntity, ListAllAccountResponseDto>
    implements IListAllAccountService {

  private final AccountRepository accountRepository;

  public ListAllAccountService(AccountRepository accountRepository) {
    super(ListAllAccountResponseDto.class);
    this.accountRepository = accountRepository;
  }

  @Override
  protected JpaRepository<AccountEntity, UUID> getRepository() {
    return accountRepository;
  }

}
