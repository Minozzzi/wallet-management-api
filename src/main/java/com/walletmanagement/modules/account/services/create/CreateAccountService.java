package com.walletmanagement.modules.account.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.create.BaseCreateService;
import com.walletmanagement.entities.AccountEntity;
import com.walletmanagement.modules.account.AccountRepository;
import com.walletmanagement.modules.account.dto.CreateAccountResponseDto;
import com.walletmanagement.modules.account.dto.CreateUpdateAccountDto;

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
