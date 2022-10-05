package com.walletmanagement.account.services.delete;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.bases.services.delete.BaseDeleteService;
import com.walletmanagement.entities.AccountEntity;

@Service
public class DeleteAccountService extends BaseDeleteService<AccountEntity> implements IDeleteAccountService {

  private final AccountRepository accountRepository;

  public DeleteAccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  protected JpaRepository<AccountEntity, UUID> getRepository() {
    return accountRepository;
  }

}
