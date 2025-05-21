package br.com.ebookofcode.service.exceptions;

public class BusinessException extends RuntimeException {

  private final ErrorCodeEnum errorCode;

  public BusinessException(ErrorCodeEnum errorCode) {
    super(errorCode.getErrorMessage());
    this.errorCode = errorCode;
  }

  public ErrorCodeEnum getErrorCode() {
    return errorCode;
  }
}
