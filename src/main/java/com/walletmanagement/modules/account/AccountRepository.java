package com.walletmanagement.modules.account;

import org.springframework.stereotype.Repository;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.entities.AccountEntity;

@Repository
public interface AccountRepository extends IBaseRepository<AccountEntity> {
}
