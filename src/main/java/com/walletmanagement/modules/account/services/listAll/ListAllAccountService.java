package com.walletmanagement.modules.account.services.listAll;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.listAll.BaseListAllService;
import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.modules.account.AccountRepository;
import com.walletmanagement.modules.account.dto.ListAllAccountResponseDto;

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
