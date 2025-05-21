package br.com.ebookofcode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User extends BaseEntity<Long> {

  @Column(name = "name",nullable = false, length = 100)
  private String name;

  @Column(name = "username", length = 20, nullable = false, unique = true)
  private String username;

  @Column(name = "email", length = 150, unique = true, nullable = false)
  private String email;

  @Column(name = "password", length = 100, nullable = false)
  private String password;

  @Column(name = "locale", length = 5)
  private String locale;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "last_update_at")
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastUpdated;

  @Column(name = "active")
  private boolean active;

  @Embedded
  private UserPersonalInfo userPersonalInfo;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "tb_user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles = new HashSet<>();

  public User() {}

  public User(Long id,
      String name,
      String username,
      String email,
      String password,
      String locale,
      LocalDateTime createdAt,
      LocalDateTime lastUpdated,
      boolean active,
      UserPersonalInfo userPersonalInfo) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.locale = locale;
    this.createdAt = createdAt;
    this.lastUpdated = lastUpdated;
    this.active = active;
    this.userPersonalInfo = userPersonalInfo;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public UserPersonalInfo getUserPersonalInfo() {
    return userPersonalInfo;
  }

  public void setUserPersonalInfo(UserPersonalInfo userPersonalInfo) {
    this.userPersonalInfo = userPersonalInfo;
  }
}
