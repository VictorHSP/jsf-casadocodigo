package br.com.ebookofcode.repository;

import br.com.ebookofcode.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

  List<Author> findPageableAuthor(final int page, final int pageSize);

  Optional<Author> findByEmail(String email);

  Long countTotalAuthors();
}
