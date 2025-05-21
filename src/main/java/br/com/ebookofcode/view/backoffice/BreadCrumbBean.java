package br.com.ebookofcode.view.backoffice;

import br.com.ebookofcode.view.backoffice.utils.BreadCrumbEnum;
import br.com.ebookofcode.view.backoffice.utils.BreadcrumbItem;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@Named
@RequestScoped
public class BreadCrumbBean implements Serializable {

  private final List<BreadcrumbItem> breadCrumbs = new ArrayList<>();

  @PostConstruct
  public void init() {
    mountBreadCrumbFromCurrentPage(FacesContext.getCurrentInstance().getViewRoot().getViewId());
  }

  private void mountBreadCrumbFromCurrentPage(String viewId) {
    StringTokenizer tokenizer = new StringTokenizer(viewId, "/");

    while (tokenizer.hasMoreTokens()) {
      var token = tokenizer.nextToken();
      var currentBread = Arrays.stream(BreadCrumbEnum.values())
          .filter(e -> token.contains(e.getPage())).findFirst()
          .orElse(null);
      if (currentBread != null && tokenizer.hasMoreElements()) {
        breadCrumbs.add(new BreadcrumbItem(currentBread.getLabel(), currentBread.getUrl()));
      }else if (currentBread != null) {
        breadCrumbs.add(new BreadcrumbItem(currentBread.getLabel(), "#"));
      }
    }
  }

  public List<BreadcrumbItem> getBreadCrumbs() {
    return breadCrumbs;
  }

}
