package br.com.casadocodigo.view.backoffice.utils;

public record BreadcrumbItem(String label, String url) {

  public String getLabel() {
    return label;
  }

  public String getUrl() {
    return url;
  }
}
