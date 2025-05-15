package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Category findByName(String name);

}
