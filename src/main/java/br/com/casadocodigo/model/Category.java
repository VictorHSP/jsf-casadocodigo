package br.com.casadocodigo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity<Long> {

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "active", nullable = false)
  private boolean active;

  @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
  @OrderBy("id ASC")
  private Set<SubCategory> subCategories;

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Category() {}

  public Category(String name, boolean active) {
    this.name = name;
    this.active = active;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Set<SubCategory> getSubCategories() {
    return subCategories;
  }

  public void setSubCategories(Set<SubCategory> subCategories) {
    this.subCategories = subCategories;
  }
}
