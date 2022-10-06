package com.walletmanagement.user.services.create;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.user.UserRepository;
import com.walletmanagement.user.dto.CreateUpdateUserDto;
import com.walletmanagement.user.dto.CreateUserResponseDto;

@Service
public class CreateUserService implements ICreateUserService {

  private final UserRepository userRepository;
  private final ModelMapper mapper;

  private BCryptPasswordEncoder passwordEncoder;

  public CreateUserService(UserRepository userRepository, ModelMapper mapper) {
    this.userRepository = userRepository;
    this.mapper = mapper;
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public CreateUserResponseDto execute(CreateUpdateUserDto user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    UserEntity userEntity = mapper.map(user, UserEntity.class);
    userEntity = userRepository.save(userEntity);
    return mapper.map(userEntity, CreateUserResponseDto.class);
  }

}
