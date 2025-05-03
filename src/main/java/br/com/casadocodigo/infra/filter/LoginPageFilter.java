package br.com.casadocodigo.infra.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login.xhtml")
public class LoginPageFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    var req = (HttpServletRequest) request;
    var res = (HttpServletResponse) response;

    var userPrincipal = req.getUserPrincipal();

    if (userPrincipal != null) {
      if (req.isUserInRole("ADMIN")) {
        res.sendRedirect(req.getContextPath() + "/admin/index.xhtml");
      } else if (req.isUserInRole("CUSTOMER")) {
        res.sendRedirect(req.getContextPath() + "/index.xhtml");
      }
    } else {
      chain.doFilter(request, response);
    }
  }
}
