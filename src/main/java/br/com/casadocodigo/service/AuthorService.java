package br.com.casadocodigo.service;

import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
import br.com.casadocodigo.service.exceptions.AuthorAlreadyExistsException;
import br.com.casadocodigo.service.exceptions.ErrorCodeEnum;
import br.com.casadocodigo.utils.S3Utils;
import br.com.casadocodigo.view.dto.FileUploadDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@RequestScoped
public class AuthorService implements Serializable {

  @Inject
  private AuthorRepository authorRepository;

  private static final String FOLDER_AUTHOR_PHOTO = "author-photo";

  public List<Author> findAuthorsPageable(final int page, final int pageSize) {
    return authorRepository.findPageableAuthor(page, pageSize);
  }

  @Transactional
  public void save(Author author, FileUploadDTO fileUpload) {
    validateIfAuthorAlreadyExists(author);

    if (fileUpload != null && fileUpload.size() > 0
        && fileUpload.fileName() != null && !fileUpload.fileName().equals(author.getUrlPhoto()) ) {
      var s3url = S3Utils.uploadFile(fileUpload, FOLDER_AUTHOR_PHOTO, author.getEmail());
      System.out.println(S3Utils.generatePreSignedUrl(s3url));
      author.setUrlPhoto(s3url);
    }

    authorRepository.save(author);
  }

  private void validateIfAuthorAlreadyExists(Author author) {
    if (author.getId() == null && authorRepository.findByEmail(author.getEmail()).isPresent()) {
      throw new AuthorAlreadyExistsException(ErrorCodeEnum.ERROR_001);
    }
  }

  public Author findById(Long id) {
    return authorRepository.findById(id);
  }

  public FileUploadDTO findAuthorPhotoOnS3(String urlPhoto) {
    return S3Utils.downloadPhoto(urlPhoto);
  }

  public Long countTotalAuthors() {
    return authorRepository.countTotalAuthors();
  }
}
