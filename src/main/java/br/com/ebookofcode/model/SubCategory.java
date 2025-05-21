package br.com.ebookofcode.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sub_category")
public class SubCategory extends BaseEntity<Long> {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private boolean active;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;


  public SubCategory() {}

  public SubCategory(String name, boolean active, Category category) {
    this.name = name;
    this.active = active;
    this.category = category;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
