package com.walletmanagement.security;

public class SecurityConstants {

  public static final String SECRET = "utfpr";
  public static final long EXPIRATION_TIME = 60 * 60 * 24 * 1000; // 1 day -> seconds * minutes * hours
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";

  private SecurityConstants() {
  }

}
