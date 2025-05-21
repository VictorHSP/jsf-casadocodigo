package br.com.casadocodigo.utils;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

@RequestScoped
public class MessageUtils implements Serializable {

  private void add(String message, Severity severity) {
    var facesMessage = new FacesMessage(severity, message, null);
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }

  public void info(String message) {
    add(message, FacesMessage.SEVERITY_INFO);
  }

  public void error(String message) {
    add(message, FacesMessage.SEVERITY_ERROR);
  }

}
