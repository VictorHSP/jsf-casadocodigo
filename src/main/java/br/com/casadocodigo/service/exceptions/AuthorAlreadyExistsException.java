package br.com.casadocodigo.service.exceptions;

public class AuthorAlreadyExistsException extends BusinessException {

  public AuthorAlreadyExistsException(ErrorCodeEnum errorCode) {
    super(errorCode);
  }
}
