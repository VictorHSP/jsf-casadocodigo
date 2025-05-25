package br.com.ebookofcode.utils.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import org.apache.commons.lang3.StringUtils;

@FacesValidator(value = "br.com.ebookofcode.EmailValidator", managed = true)
public class EmailValidator implements Validator<String> {

  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, String email)
      throws ValidatorException {
    if (StringUtils.isNoneEmpty(email) && !email.matches("^[a-zA-Z0-9_%+-]+(\\.[a-zA-Z0-9_%+-]+)*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
      String descriptionError = String.format("O %s informado: %s, não está válido.".formatted(uiComponent.getId(), email));
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          descriptionError, descriptionError);
      throw new ValidatorException(message);
    }
  }
}
