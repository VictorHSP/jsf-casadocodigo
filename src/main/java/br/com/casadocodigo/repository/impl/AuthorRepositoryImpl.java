package br.com.casadocodigo.repository.impl;

import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.commons.collections4.CollectionUtils;

public class AuthorRepositoryImpl implements AuthorRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Author> findPageableAuthor(final int page, final int pageSize) {
    var authors = entityManager.createQuery("SELECT a FROM Author a ORDER BY a.id", Author.class)
        .setFirstResult(page * pageSize)
        .setMaxResults(pageSize)
        .getResultList();
    return CollectionUtils.isEmpty(authors) ? Collections.emptyList() : authors;
  }

  @Override
  public Optional<Author> findByEmail(String email) {
    try {
      return Optional.of(entityManager.createQuery("SELECT a from Author a WHERE a.email = :email", Author.class)
          .setParameter("email", email).getSingleResult());
    }catch (NoResultException ex) {
      return Optional.empty();
    }
  }

  @Override
  public Long countTotalAuthors() {
    return entityManager.createQuery("SELECT COUNT(a) FROM Author a WHERE a.deleted is false", Long.class)
        .getSingleResult();
  }

  @Override
  public void save(Author entity) {
    entityManager.merge(entity);
  }

  @Override
  public void merge(Author entity) {

  }

  @Override
  public void delete(Author entity) {

  }

  @Override
  public Author findById(Long id) {
    return entityManager.find(Author.class, id);
  }

  @Override
  public Collection<Author> findAll() {
    return entityManager.createQuery("SELECT a FROM Author a", Author.class)
        .getResultList();
  }
}
