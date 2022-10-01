package com.walletmanagement.account.services.update;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.account.dto.CreateUpdateAccountDto;
import com.walletmanagement.bases.services.update.BaseUpdateService;
import com.walletmanagement.entities.AccountEntity;

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
