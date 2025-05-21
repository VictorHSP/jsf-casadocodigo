package br.com.ebookofcode.service;

import br.com.ebookofcode.model.User;
import br.com.ebookofcode.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@RequestScoped
public class UserService implements Serializable {

  @Inject
  private UserRepository userRepository;

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Transactional
  public void save(User user) {
    userRepository.save(user);
  }

  @Transactional
  public void update(User user) {
    userRepository.merge(user);
  }

  @Transactional
  public void delete(User user) {
    userRepository.delete(user);
  }

  public List<User> findAll() {
    return userRepository.findAll()
        .stream().toList();
  }

}
