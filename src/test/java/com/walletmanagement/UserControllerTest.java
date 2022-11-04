package com.walletmanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.walletmanagement.bases.BaseTest;
import com.walletmanagement.builders.UserBuilder;
import com.walletmanagement.entities.UserEntity;
import com.walletmanagement.matchers.IsUUID;
import com.walletmanagement.modules.user.UserRepository;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;
import com.walletmanagement.modules.user.dto.CreateUserResponseDto;
import com.walletmanagement.shared.error.ApiError;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class UserControllerTest extends BaseTest<UserEntity, UserRepository> {

  private UserBuilder userBuilder;

  @BeforeAll()
  public void setup() {
    this.userBuilder = new UserBuilder(this.faker);
  }

  @Test
  public void postUser_whenUserIsValid_receiveCreated() {
    CreateUpdateUserDto user = userBuilder.validUser();

    ResponseEntity<CreateUserResponseDto> response = restTemplate.postForEntity("/user", user,
        CreateUserResponseDto.class);

    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    CreateUserResponseDto returnedUser = response.getBody();

    Assertions.assertNotNull(returnedUser);
    Assertions.assertEquals(CreateUserResponseDto.class, returnedUser.getClass());
    Assertions.assertEquals(true, new IsUUID().matchesSafely(returnedUser.getId()));
    Assertions.assertEquals(user.getName(), returnedUser.getName());
  }

  @Test
  public void postUser_whenUserIsInvalidName_receiveBadRequest() {
    CreateUpdateUserDto user = userBuilder.invalidNameUser();

    ResponseEntity<ApiError> response = restTemplate.postForEntity("/user", user,
        ApiError.class);

    ApiError error = response.getBody();

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());


    Assertions.assertNotNull(error);
    Assertions.assertEquals(ApiError.class, error.getClass());
    Assertions.assertEquals("validation error", error.getMessage());
    Assertions.assertEquals("/api/v1/user", error.getUrl());
    Assertions.assertEquals(1, error.getValidationErrors().size());
    Assertions.assertEquals("must not be blank", error.getValidationErrors().get("name"));
  }

  @Test
  public void postUser_whenUserIsInvalidPassword_receiveBadRequest() {
    CreateUpdateUserDto user = userBuilder.invalidPasswordUser();

    ResponseEntity<ApiError> response = restTemplate.postForEntity("/user", user,
        ApiError.class);

    ApiError error = response.getBody();

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    Assertions.assertNotNull(error);
    Assertions.assertEquals(ApiError.class, error.getClass());
    Assertions.assertEquals("validation error", error.getMessage());
    Assertions.assertEquals("/api/v1/user", error.getUrl());
    Assertions.assertEquals(1, error.getValidationErrors().size());
    Assertions.assertEquals(
        "The password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character",
        error.getValidationErrors().get("password"));
  }

  @Test
  public void postUser_whenUserIsInvalidUsername_receiveBadRequest() {
    CreateUpdateUserDto user = userBuilder.invalidUsernameUser();

    ResponseEntity<ApiError> response = restTemplate.postForEntity("/user", user,
        ApiError.class);

    ApiError error = response.getBody();

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    Assertions.assertNotNull(error);
    Assertions.assertEquals(ApiError.class, error.getClass());
    Assertions.assertEquals("validation error", error.getMessage());
    Assertions.assertEquals("/api/v1/user", error.getUrl());
    Assertions.assertEquals(1, error.getValidationErrors().size());
    Assertions.assertEquals("must not be blank", error.getValidationErrors().get("username"));
  }

}
