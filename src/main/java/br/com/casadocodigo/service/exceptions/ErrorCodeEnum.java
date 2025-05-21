package br.com.casadocodigo.service.exceptions;

public enum ErrorCodeEnum {

  ERROR_001("001", "Author already exists with this email.", 400);

  private final String errorCode;
  private final String errorMessage;
  private final Integer httpStatusCode;

  ErrorCodeEnum(String errorCode, String errorMessage, Integer httpStatusCode) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.httpStatusCode = httpStatusCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
