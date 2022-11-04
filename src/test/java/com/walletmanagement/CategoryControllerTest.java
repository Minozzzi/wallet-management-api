package com.walletmanagement;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.walletmanagement.bases.BaseTest;
import com.walletmanagement.builders.CategoryBuilder;
import com.walletmanagement.entities.CategoryEntity;
import com.walletmanagement.matchers.IsUUID;
import com.walletmanagement.modules.category.CategoryRepository;
import com.walletmanagement.modules.category.dto.CreateCategoryResponseDto;
import com.walletmanagement.modules.category.dto.CreateUpdateCategoryDto;
import com.walletmanagement.modules.user.dto.CreateUpdateUserDto;
import com.walletmanagement.searchers.CategorySearcher;
import com.walletmanagement.services.CreateHttpHeaders;
import com.walletmanagement.services.UserService;
import com.walletmanagement.shared.error.ApiError;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class CategoryControllerTest extends BaseTest<CategoryEntity, CategoryRepository> {

  private CategoryBuilder categoryBuilder;

  private UserService userServiceTest;

  private CategorySearcher categorySearcher;

  @BeforeAll()
  public void setup() {
    this.categoryBuilder = new CategoryBuilder(this.faker);
    this.userServiceTest = new UserService(this.restTemplate, this.faker);
    this.categorySearcher = new CategorySearcher(this.repository);
  }

  @BeforeEach()
  public void setToken() {
    CreateUpdateUserDto user = this.userServiceTest.createUser();
    HttpHeaders headers = CreateHttpHeaders.createHttpHeaders(this.userServiceTest.authenticateUser(user));

    this.restTemplate.getRestTemplate().setInterceptors(List.of((request, body, execution) -> {
      request.getHeaders().addAll(headers);
      return execution.execute(request, body);
    }));
  }

  @Test
  public void postCategory_whenCategoryIsValid_receiveCreated() {
    CreateUpdateCategoryDto category = categoryBuilder.validCategory();

    ResponseEntity<CreateCategoryResponseDto> response = this.restTemplate.postForEntity("/category",
        category, CreateCategoryResponseDto.class);

    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    CreateCategoryResponseDto returnedCategory = response.getBody();

    Assertions.assertNotNull(returnedCategory);
    Assertions.assertEquals(CreateCategoryResponseDto.class, returnedCategory.getClass());
    Assertions.assertEquals(true, new IsUUID().matchesSafely(returnedCategory.getId()));
    Assertions.assertEquals(category.getName(), returnedCategory.getName());
  }

  @Test
  public void postCategory_whenCategoryIsWithoutName_receiveBadRequest() {
    CreateUpdateCategoryDto category = categoryBuilder.invalidWithoutNameCategory();

    ResponseEntity<ApiError> response = this.restTemplate.postForEntity("/category", category,
        ApiError.class);

    ApiError error = response.getBody();

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    Assertions.assertNotNull(error);
    Assertions.assertEquals(ApiError.class, error.getClass());
    Assertions.assertEquals("validation error", error.getMessage());
    Assertions.assertEquals("/api/v1/category", error.getUrl());
    Assertions.assertEquals(1, error.getValidationErrors().size());
    Assertions.assertEquals("must not be blank", error.getValidationErrors().get("name"));
  }

  @Test
  public void postCategory_whenCategoryIsNullName_receiveBadRequest() {
    CreateUpdateCategoryDto category = categoryBuilder.invalidNullNameCategory();

    ResponseEntity<ApiError> response = this.restTemplate.postForEntity("/category", category,
        ApiError.class);

    ApiError error = response.getBody();

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    Assertions.assertNotNull(error);
    Assertions.assertEquals(ApiError.class, error.getClass());
    Assertions.assertEquals("validation error", error.getMessage());
    Assertions.assertEquals("/api/v1/category", error.getUrl());
    Assertions.assertEquals(1, error.getValidationErrors().size());
    Assertions.assertEquals("must not be blank", error.getValidationErrors().get("name"));
  }

  @Test
  public void patchCategory_whenCategoryIsValid_receiveOk() {
    CreateUpdateCategoryDto category = categoryBuilder.validCategory();
    String nameToUpdate = this.faker.lorem().word();

    ResponseEntity<CreateCategoryResponseDto> createdCategoryResponse = this.restTemplate.postForEntity("/category",
        category, CreateCategoryResponseDto.class);

    CreateCategoryResponseDto createdCategory = createdCategoryResponse.getBody();

    Assertions.assertNotNull(createdCategory);
    Assertions.assertEquals(category.getName(), createdCategory.getName());

    category.setName(nameToUpdate);

    ResponseEntity<Void> response = this.restTemplate.patchForObject("/category/" + createdCategory.getId(),
        category, ResponseEntity.class);

    Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    Optional<CategoryEntity> updatedCategory = this.categorySearcher.findById(createdCategory.getId());

    Assertions.assertTrue(updatedCategory.isPresent());
    Assertions.assertEquals(nameToUpdate, updatedCategory.get().getName());

  }

}
