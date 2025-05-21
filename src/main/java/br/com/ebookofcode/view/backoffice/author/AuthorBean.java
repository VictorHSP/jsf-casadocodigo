package br.com.ebookofcode.view.backoffice.author;

import br.com.ebookofcode.model.Author;
import br.com.ebookofcode.service.AuthorService;
import br.com.ebookofcode.view.BaseBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AuthorBean extends BaseBean implements Serializable {

  private List<Author> authors;
  private int page = 0;
  private final int pageSize = 5;
  private long totalAuthors;

  @Inject
  private AuthorService authorService;
  private String emailSearch;

  @PostConstruct
  public void init() {
    totalAuthors = authorService.countTotalAuthors();
    loadPageableAuthors();
  }

  public void loadPageableAuthors() {
    authors = authorService.findAuthorsPageable(page, pageSize);
  }

  public void nextPage() {
    page++;
    loadPageableAuthors();
  }

  public void previousPage() {
    if (page > 0) page--;
    loadPageableAuthors();
  }

  public boolean isFirstPage() {
    return page == 0;
  }

  public boolean isLastPage() {
    return (page + 1L) * pageSize >= totalAuthors;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public void searchByEmail() {
    System.out.println("searchByEmail");
  }

  public String getEmailSearch() {
    return emailSearch;
  }

  public void setEmailSearch(String emailSearch) {
    this.emailSearch = emailSearch;
  }
}
