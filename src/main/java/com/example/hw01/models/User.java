package com.example.hw01.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.HashSet;

@Entity
@Table (name = "users")
public class User {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String address;
  private Date dob;
  private Timestamp registeredDate;
  private String role;
/*
  @OneToMany(cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      mappedBy = "user")
  private Set<Review> reviews = new HashSet<>();


  public Set<Review> getReviews () {
    return reviews;
  }

  public void setReviews (Set<Review> reviews) {
    this.reviews = reviews;
  }
*/
  public Integer getUserId () {
    return userId;
  }

  public void setUserId (Integer userId) {
    this.userId = userId;
  }

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

  public Date getDob () {
    return dob;
  }

  public void setDob (Date dob) {
    this.dob = dob;
  }

  public Timestamp getRegisteredDate () {
    return registeredDate;
  }

  public void setRegisteredDate (Timestamp registeredDate) {
    this.registeredDate = registeredDate;
  }
}
