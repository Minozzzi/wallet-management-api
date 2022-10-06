package com.walletmanagement.modules.user.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUserResponseDto {

  private UUID id;
  private String name;

}
