package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

}
