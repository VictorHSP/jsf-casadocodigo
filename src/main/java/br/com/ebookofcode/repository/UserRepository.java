package br.com.ebookofcode.repository;

import br.com.ebookofcode.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

}
