package br.com.casadocodigo.view;

import br.com.casadocodigo.infra.security.CustomPrincipal;
import br.com.casadocodigo.model.User;
import br.com.casadocodigo.service.UserService;
import com.sun.security.auth.UserPrincipal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class UserBean implements Serializable {

  private static final Logger log = LoggerFactory.getLogger(UserBean.class);
  @Inject
  private UserService userService;

  @Inject
  private SecurityContext securityContext;

  private User user;

  @PostConstruct
  public void init() {
    var userPrincipal = securityContext.getCallerPrincipal();
    if (!(userPrincipal instanceof CustomPrincipal))
      log.warn("User Principal fudeu!");
    user = userService.findByEmail(((CustomPrincipal) userPrincipal).getEmail());
  }

  public User getUser() {
    return user;
  }
}
