package com.walletmanagement.modules.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.walletmanagement.shared.validations.uniqueUsername.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUpdateUserDto {

  @NotNull
  @NotBlank
  @UniqueUsername
  private String username;

  @NotNull
  @NotBlank
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[0-9a-zA-Z!@#$%^&*]{8,}$", message = "The password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character")
  private String password;

  @NotNull
  @NotBlank
  private String name;

}
