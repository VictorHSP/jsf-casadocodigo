package br.com.casadocodigo.repository.impl;

import br.com.casadocodigo.model.User;
import br.com.casadocodigo.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class UserRepositoryImpl implements UserRepository {


  private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

  @PersistenceContext
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
    try {
      return entityManager.createQuery("select u from User u left join fetch u.roles where u.email = :email", User.class)
          .setParameter("email", email).getSingleResult();
    }catch (NoResultException ex) {
      logger.warn("Not found any user with this email {}",email, ex);
    }

    return null;
  }
}
