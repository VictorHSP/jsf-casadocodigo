package br.com.casadocodigo.view.backoffice.utils;

public enum BreadCrumbEnum {

  ADMIN("/admin/index.xhtml", "admin", "Administrador"),
  AUTHORS("/admin/author/index.xhtml", "author", "Autores"),
  NEW_AUTHOR("/admin/author/newAuthor.xhtml", "newAuthor", "Novos Autores");

  private final String url;
  private final String page;
  private final String label;

  BreadCrumbEnum(String url, String page, String label) {
    this.url = url;
    this.page = page;
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public String getUrl() {
    return url;
  }

  public String getPage() {
    return page;
  }
}
