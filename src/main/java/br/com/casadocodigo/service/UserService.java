package br.com.casadocodigo.service;

import br.com.casadocodigo.model.User;
import br.com.casadocodigo.repository.impl.UserRepositoryImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class UserService implements Serializable {

  @Inject
  private UserRepositoryImpl userRepository;

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

}
