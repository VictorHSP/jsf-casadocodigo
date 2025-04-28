package br.com.casadocodigo;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  private String message;
  Logger logger = LoggerFactory.getLogger(HelloServlet.class);
  public void init() {
    message = "Hello Servlet!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    // Logar mensagens de diferentes níveis
    logger.trace("Mensagem TRACE");
    logger.debug("Mensagem DEBUG");
    logger.info("Mensagem INFO");
    logger.warn("Mensagem WARN");
    logger.error("Mensagem ERROR");

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}
