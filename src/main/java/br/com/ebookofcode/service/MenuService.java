package br.com.ebookofcode.service;

import br.com.ebookofcode.model.Category;
import br.com.ebookofcode.repository.CategoryRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class MenuService implements Serializable {

  @Inject
  private CategoryRepository categoryRepository;


  public List<Category> findCategories() {
    return categoryRepository.findAll()
        .stream()
        .filter(Category::isActive)
        .collect(Collectors.toList());
  }
}
