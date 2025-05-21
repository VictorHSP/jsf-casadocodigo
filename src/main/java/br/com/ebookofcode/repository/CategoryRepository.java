package br.com.ebookofcode.repository;

import br.com.ebookofcode.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Category findByName(String name);

}
