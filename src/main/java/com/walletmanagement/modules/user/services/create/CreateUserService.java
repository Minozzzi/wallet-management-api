package com.walletmanagement.modules.user.services.create;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.modules.user.UserRepository;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;
import com.walletmanagement.modules.user.dto.CreateUserResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService implements ICreateUserService {

  private final UserRepository userRepository;
  private final ModelMapper mapper;
  private final BCryptPasswordEncoder passwordEncoder;

  public CreateUserResponseDto execute(CreateUpdateUserDto user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    UserEntity userEntity = mapper.map(user, UserEntity.class);
    userEntity = userRepository.save(userEntity);
    return mapper.map(userEntity, CreateUserResponseDto.class);
  }

}
