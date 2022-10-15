package com.walletmanagement.modules.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.walletmanagement.shared.validations.uniqueUsername.UniqueUsername;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUpdateUserDto {

  @NotNull
  @NotBlank
  @UniqueUsername
  private String username;

  @NotNull
  @NotBlank
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9 a-zA-Z$*&@#]{8,}$", message = "A senha deve conter pelo menos 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
  private String password;

  @NotNull
  @NotBlank
  private String name;

}
