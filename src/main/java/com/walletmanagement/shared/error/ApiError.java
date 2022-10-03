package com.walletmanagement.shared.error;

import java.time.Instant;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

  private Instant timestamp = Instant.now();
  private int status;
  private String message;
  private String url;
  private Map<String, String> validationErrors;

  public ApiError(int status, String message, String url,
      Map<String, String> validationErrors) {
    this.status = status;
    this.message = message;
    this.url = url;
    this.validationErrors = validationErrors;
  }

  public ApiError(int status, String message, String url) {
    this.status = status;
    this.message = message;
    this.url = url;
  }

}
