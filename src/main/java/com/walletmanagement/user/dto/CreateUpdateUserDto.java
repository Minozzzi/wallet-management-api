package com.walletmanagement.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateUserDto {

  @NotNull
  @NotBlank
  private String username;

  @NotNull
  @NotBlank
  private String password;

  @NotNull
  @NotBlank
  private String name;

}
