package com.walletmanagement.user.services.create;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.walletmanagement.bases.services.create.BaseCreateService;
import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.user.UserRepository;
import com.walletmanagement.user.dto.CreateUpdateUserDto;
import com.walletmanagement.user.dto.CreateUserResponseDto;

@Service
public class CreateUserService extends BaseCreateService<UserEntity, CreateUpdateUserDto, CreateUserResponseDto, UUID>
    implements ICreateUserService {

  private final UserRepository userRepository;

  public CreateUserService(UserRepository userRepository) {
    super(UserEntity.class, CreateUserResponseDto.class);
    this.userRepository = userRepository;
  }

  @Override
  protected JpaRepository<UserEntity, UUID> getRepository() {
    return this.userRepository;
  }

}
