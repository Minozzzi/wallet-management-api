package com.walletmanagement.shared.validations.uniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.walletmanagement.user.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  UserRepository userRepository;

  public UniqueUsernameValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    return userRepository.findByUsername(username) == null;
  }

}
