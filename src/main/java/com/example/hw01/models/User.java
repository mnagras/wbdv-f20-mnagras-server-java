package com.example.hw01.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer userId;

  public Integer getUserId () {
    return userId;
  }

  public void setUserId (Integer userId) {
    this.userId = userId;
  }

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String address;

  public String getPhoneNumber () {
    return phoneNumber;
  }

  public void setPhoneNumber (String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress () {
    return address;
  }

  public void setAddress (String address) {
    this.address = address;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  private String password;

  public User (Integer userId, String firstName, String lastName, String email, String phoneNumber, String address, String role, String password) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.role = role;
    this.password = password;
  }

  private String role;

  public String getRole () {
    return role;
  }

  public void setRole (String role) {
    this.role = role;
  }

  public User () {
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getFirstName () {
    return firstName;
  }

  public void setFirstName (String firstName) {
    this.firstName = firstName;
  }

  public String getLastName () {
    return lastName;
  }

  public void setLastName (String lastName) {
    this.lastName = lastName;
  }
}
