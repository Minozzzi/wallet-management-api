package com.walletmanagement.user;

import org.springframework.stereotype.Repository;

import com.walletmanagement.bases.repositories.IBaseRepository;
import com.walletmanagement.entities.UserEntity;

@Repository
public interface UserRepository extends IBaseRepository<UserEntity> {

  UserEntity findByUsername(String username);

}
