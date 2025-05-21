package br.com.ebookofcode.repository.impl;

import br.com.ebookofcode.model.Category;
import br.com.ebookofcode.repository.CategoryRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

@RequestScoped
public class CategoryRepositoryImpl implements CategoryRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Category findByName(String name) {
    return null;
  }

  @Override
  public void save(Category entity) {
    entityManager.merge(entity);
  }

  @Override
  public void merge(Category entity) {
    entityManager.merge(entity);
  }

  @Override
  public void delete(Category entity) {
    var entityToDelete = findById(entity.getId());
    entityManager.remove(entityToDelete);
  }

  @Override
  public Category findById(Long id) {
    return entityManager.find(Category.class, id);
  }

  @Override
  public Collection<Category> findAll() {
    return entityManager.createQuery("select c from Category c", Category.class)
        .getResultList();
  }
}
