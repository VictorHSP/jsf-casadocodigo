package br.com.casadocodigo.infra.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.casadocodigo.model.Role;
import br.com.casadocodigo.model.User;
import br.com.casadocodigo.repository.UserRepository;
import jakarta.annotation.Priority;
import static jakarta.interceptor.Interceptor.Priority.APPLICATION;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Priority(APPLICATION)
@ApplicationScoped
public class DatabaseIdentityStore implements IdentityStore {

  @Inject private UserRepository userRepository;

  @Override
  public CredentialValidationResult validate(Credential credential) {
    var userNamePasswordCredential = (UsernamePasswordCredential) credential;
    User user = userRepository.findByEmail(userNamePasswordCredential.getCaller());

    if (Objects.nonNull(user) && verifyPassword(userNamePasswordCredential.getPasswordAsString(), user.getPassword())) {
      Set<String> roles = user.getRoles().stream()
          .map(Role::getName).collect(Collectors.toSet());
      return new CredentialValidationResult(new CustomPrincipal(user), roles);
    }

    return CredentialValidationResult.INVALID_RESULT;
  }

  private boolean verifyPassword(String clientPassword, String databasePassword) {
    return BCrypt.verifyer()
        .verify(clientPassword.toCharArray(), databasePassword)
        .verified;
  }
}
