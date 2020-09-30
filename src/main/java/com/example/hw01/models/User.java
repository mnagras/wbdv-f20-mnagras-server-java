package com.example.hw01.models;

public class User {
  private int userId;

  public int getUserId () {
    return userId;
  }

  public void setUserId (int userId) {
    this.userId = userId;
  }

  private String username;
  private String firstName;
  private String lastName;

  public User () {
  }

  public User (int userId, String username, String firstName, String lastName) {
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
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
