package com.walletmanagement.builders;

import com.github.javafaker.Faker;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserBuilder {

  private final Faker faker;

  public CreateUpdateUserDto validUser() {
    return CreateUpdateUserDto.builder()
        .name(faker.name().fullName())
        .username(faker.name().username())
        .password(faker.internet().password(8, 16, true, true, true) + "a")
        .build();
  }

  public CreateUpdateUserDto invalidPasswordUser() {
    return CreateUpdateUserDto.builder()
        .name(faker.name().fullName())
        .username(faker.name().username())
        .password("123")
        .build();
  }

  public CreateUpdateUserDto invalidUsernameUser() {
    return CreateUpdateUserDto.builder()
        .name(faker.name().fullName())
        .username("")
        .password(faker.internet().password(8, 16, true, true, true) + "a")
        .build();
  }

  public CreateUpdateUserDto invalidNameUser() {
    return CreateUpdateUserDto.builder()
        .name("")
        .username(faker.name().username())
        .password(faker.internet().password(8, 16, true, true, true) + "a")
        .build();
  }

}
