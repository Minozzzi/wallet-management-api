package com.walletmanagement.services;

import java.util.HashMap;

import org.springframework.boot.test.web.client.TestRestTemplate;

import com.github.javafaker.Faker;
import com.walletmanagement.builders.UserBuilder;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;
import com.walletmanagement.modules.user.dto.CreateUserResponseDto;

public class UserService {

  private final TestRestTemplate restTemplate;

  private final Faker faker;

  private final UserBuilder userBuilder;

  public UserService(TestRestTemplate restTemplate, Faker faker) {
    this.restTemplate = restTemplate;
    this.faker = faker;
    this.userBuilder = new UserBuilder(this.faker);
  }

  public CreateUpdateUserDto createUser() {
    CreateUpdateUserDto user = this.userBuilder.validUser();

    restTemplate.postForEntity("/user", user,
        CreateUserResponseDto.class);

    return user;
  }

  public String authenticateUser(CreateUpdateUserDto user) {
    HashMap<String, String> response = restTemplate.postForEntity("/login", user,
        HashMap.class).getBody();

    if (response == null) {
      return null;
    }

    return response.get("token");
  }

}
