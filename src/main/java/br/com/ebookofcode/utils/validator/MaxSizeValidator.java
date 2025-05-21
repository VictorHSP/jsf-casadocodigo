package br.com.ebookofcode.utils.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.servlet.http.Part;

@FacesValidator(value = "br.com.ebookofcode.MaxSizeValidator", managed = true)
public class MaxSizeValidator implements Validator<Part> {

  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Part value)
      throws ValidatorException {
    Object maxSizeAttr = uiComponent.getAttributes().get("maxSize");

    long maxSize = 10 * 1024 * 1024; // default value 10MB

    if (maxSizeAttr != null) {
      maxSize = Long.parseLong(maxSizeAttr.toString());
    }

    if (value != null && value.getSize() > maxSize) {
      throw new ValidatorException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "File is too large.",
          "The file exceed the limit for upload " + (maxSize / (1024 * 1024)) + "MB."
      ));
    }
  }
}
