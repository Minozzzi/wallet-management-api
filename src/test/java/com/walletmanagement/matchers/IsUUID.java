package com.walletmanagement.matchers;

import java.util.UUID;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsUUID extends TypeSafeMatcher<UUID> {

  @Override
  public void describeTo(Description description) {
    description.appendText("Is a valid UUID");
  }

  @Override
  public boolean matchesSafely(UUID item) {
    try {
      UUID.fromString(item.toString());
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public static Matcher<UUID> isUUID() {
    return new IsUUID();
  }

}
