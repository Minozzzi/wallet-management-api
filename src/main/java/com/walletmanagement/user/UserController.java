package com.walletmanagement.user;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walletmanagement.bases.services.create.IBaseCreateService;
import com.walletmanagement.user.dto.CreateUpdateUserDto;
import com.walletmanagement.user.dto.CreateUserResponseDto;

@RestController
@RequestMapping("user")
public class UserController {

  private final IBaseCreateService<CreateUpdateUserDto, CreateUserResponseDto> createUserService;

  public UserController(IBaseCreateService<CreateUpdateUserDto, CreateUserResponseDto> createUserService) {
    this.createUserService = createUserService;
  }

  @PostMapping
  public ResponseEntity<CreateUserResponseDto> create(@Valid @RequestBody CreateUpdateUserDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.createUserService.execute(dto));
  }

}
