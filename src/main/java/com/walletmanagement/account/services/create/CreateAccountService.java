package com.walletmanagement.account.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.account.AccountRepository;
import com.walletmanagement.account.dto.CreateAccountResponseDto;
import com.walletmanagement.account.dto.CreateUpdateAccountDto;
import com.walletmanagement.bases.services.create.BaseCreateService;
import com.walletmanagement.entities.AccountEntity;

@Service
public class CreateAccountService
    extends BaseCreateService<AccountEntity, CreateUpdateAccountDto, CreateAccountResponseDto, UUID>
    implements ICreateAccountService {

  private final AccountRepository accountRepository;

  public CreateAccountService(AccountRepository accountRepository) {
    super(AccountEntity.class, CreateAccountResponseDto.class);
    this.accountRepository = accountRepository;
  }

  @Override
  protected JpaRepository<AccountEntity, UUID> getRepository() {
    return accountRepository;
  }

}
