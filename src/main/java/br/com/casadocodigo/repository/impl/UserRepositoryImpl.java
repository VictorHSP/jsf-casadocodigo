package br.com.casadocodigo.repository.impl;

import br.com.casadocodigo.model.User;
import br.com.casadocodigo.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.Collection;

@RequestScoped
public class UserRepositoryImpl implements UserRepository {

  @Inject
  private EntityManager entityManager;

  @Override
  public void save(User entity) {
    entityManager.persist(entity);
  }

  @Override
  public void merge(User entity) {
    entityManager.merge(entity);
  }

  @Override
  public void delete(User entity) {
    var entityToDelete = findById(entity.getId());
    entityManager.remove(entityToDelete);
  }

  @Override
  public User findById(Long id) {
    return entityManager.find(User.class, id);
  }

  @Override
  public Collection<User> findAll() {
    return entityManager.createQuery("select u from User u", User.class)
        .getResultList();
  }

  @Override
  public User findByEmail(String email) {
      return entityManager.createQuery("select u from User u where u.email = :email", User.class)
          .setParameter("email", email).getSingleResult();
  }
}
