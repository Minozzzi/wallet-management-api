package com.walletmanagement.modules.account.services.update;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.update.BaseUpdateService;
import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.modules.account.AccountRepository;
import com.walletmanagement.modules.account.dto.CreateUpdateAccountDto;

@Service
public class UpdateAccountService
    extends BaseUpdateService<AccountEntity, CreateUpdateAccountDto>
    implements IUpdateAccountService {

  private final AccountRepository accountRepository;

  public UpdateAccountService(AccountRepository accountRepository) {
    super(AccountEntity.class);
    this.accountRepository = accountRepository;
  }

  @Override
  protected JpaRepository<AccountEntity, UUID> getRepository() {
    return accountRepository;
  }

}
