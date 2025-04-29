package br.com.casadocodigo.view;

import br.com.casadocodigo.model.User;
import br.com.casadocodigo.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class UserBean implements Serializable {

  @Inject
  private UserService userService;
  private User user;

  @PostConstruct
  public void init() {
    user = userService.findByEmail("victor@gmail.com");
  }

  public User getUser() {
    return user;
  }
}
