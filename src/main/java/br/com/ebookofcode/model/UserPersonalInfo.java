package br.com.ebookofcode.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPersonalInfo implements Serializable {

  private String address;
  private Integer number;
  private String zipcode;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;
  private String country;
  private String cellphone;


  public UserPersonalInfo() {}

  public UserPersonalInfo(String address,
      Integer number,
      String zipcode,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String cellphone) {
    this.address = address;
    this.number = number;
    this.zipcode = zipcode;
    this.complement = complement;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
    this.country = country;
    this.cellphone = cellphone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }
}
