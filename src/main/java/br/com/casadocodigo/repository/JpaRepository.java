package br.com.casadocodigo.repository;

import java.io.Serializable;
import java.util.Collection;

public interface JpaRepository<T, L> extends Serializable {

  void save(T entity);
  void merge(T entity);
  void delete(T entity);
  T findById(L id);
  Collection<T> findAll();

}
