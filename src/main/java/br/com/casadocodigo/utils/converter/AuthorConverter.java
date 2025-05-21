package br.com.casadocodigo.utils.converter;

import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.service.AuthorService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

@FacesConverter(forClass = Author.class, managed = true)
public class AuthorConverter implements Converter<Author>, Serializable {

  @Inject
  private AuthorService authorService;

  @Override
  public Author getAsObject(FacesContext context, UIComponent component, String id) {
    if (StringUtils.isBlank(id) || StringUtils.isBlank(id.trim()) || !StringUtils.isNumeric(id)) {
      return null;
    }

    return authorService.findById(Long.valueOf(id));
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Author author) {
    if (author == null || author.getId() == null) {
      return null;
    }

    return author.getId().toString();
  }
}
