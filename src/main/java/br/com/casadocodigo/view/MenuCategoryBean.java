package br.com.casadocodigo.view;

import br.com.casadocodigo.model.Category;
import br.com.casadocodigo.service.MenuService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class MenuCategoryBean implements Serializable {

  private List<Category> categories;

  @Inject
  private MenuService menuService;

  @PostConstruct
  public void init() {
    categories = menuService.findCategories();
  }


  public List<Category> getCategories() {
    return categories;
  }
}
