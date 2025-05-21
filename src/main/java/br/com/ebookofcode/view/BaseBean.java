package br.com.ebookofcode.view;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

public abstract class BaseBean implements Serializable {

  public boolean isGlobalErrorPresent() {
    return FacesContext.getCurrentInstance().getMessageList(null)
        .stream()
        .anyMatch(msg -> msg.getSeverity() != null && FacesMessage.SEVERITY_ERROR.equals(msg.getSeverity()));
  }

  public boolean isGlobalInfoPresent() {
    return FacesContext.getCurrentInstance().getMessageList(null)
        .stream()
        .anyMatch(msg -> msg.getSeverity() != null && FacesMessage.SEVERITY_INFO.equals(msg.getSeverity()));
  }

  public boolean isGlobalWarnPresent() {
    return FacesContext.getCurrentInstance().getMessageList(null)
        .stream()
        .anyMatch(msg -> msg.getSeverity() != null && FacesMessage.SEVERITY_WARN.equals(msg.getSeverity()));
  }

}
