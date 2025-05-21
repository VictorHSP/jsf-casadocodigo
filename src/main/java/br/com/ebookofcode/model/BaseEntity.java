package br.com.ebookofcode.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected T id;

  public abstract T getId();
  public abstract void setId(T id);


  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity<?> that = (BaseEntity<?>) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
