package br.com.casadocodigo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_author")
public class Author extends BaseEntity<Long> {

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "email", nullable = false, length = 150, unique = true)
  private String email;

  @Column(columnDefinition = "TEXT", name = "bio", nullable = false)
  private String bio;

  @Column(name = "url_photo", length = 150)
  private String urlPhoto;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "last_update_at")
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastUpdateAt = LocalDateTime.now();

  @Column(name = "deleted")
  private boolean deleted;

  @Transient
  private String authorPhotoSavedUrl;

  public Author() {}

  public Author(String name,
      String email,
      String bio,
      String urlPhoto,
      boolean deleted) {
    this.name = name;
    this.email = email;
    this.bio = bio;
    this.urlPhoto = urlPhoto;
    this.deleted = deleted;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getUrlPhoto() {
    return urlPhoto;
  }

  public void setUrlPhoto(String urlPhoto) {
    this.urlPhoto = urlPhoto;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getLastUpdateAt() {
    return lastUpdateAt;
  }

  public void setLastUpdateAt(LocalDateTime lastUpdateAt) {
    this.lastUpdateAt = lastUpdateAt;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public String getAuthorPhotoSavedUrl() {
    return authorPhotoSavedUrl;
  }

  public void setAuthorPhotoSavedUrl(String authorPhotoSavedUrl) {
    this.authorPhotoSavedUrl = authorPhotoSavedUrl;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }
}
