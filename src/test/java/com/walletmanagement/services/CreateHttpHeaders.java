package com.walletmanagement.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CreateHttpHeaders {

  public static HttpHeaders createHttpHeaders(String token) {
    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    return headers;
  }

}
