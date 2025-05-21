package br.com.ebookofcode.service.exceptions;

public class AuthorAlreadyExistsException extends BusinessException {

  public AuthorAlreadyExistsException(ErrorCodeEnum errorCode) {
    super(errorCode);
  }
}
