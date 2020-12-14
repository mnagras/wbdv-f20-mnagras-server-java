package com.example.hw01.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "follows")
public class Follow {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer followId;
  private Integer userId;
  private Integer followerId;
  @Column (insertable=false, updatable=false)
  private String firstName;
  @Column(insertable=false, updatable=false)
  private String lastName;

  public Integer getFollowId () {
    return followId;
  }

  public void setFollowId (Integer followId) {
    this.followId = followId;
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

  public Follow () {
  }

  public Integer getUserId () {
    return userId;
  }

  public void setUserId (Integer userId) {
    this.userId = userId;
  }

  public Integer getFollowerId () {
    return followerId;
  }

  public void setFollowerId (Integer followerId) {
    this.followerId = followerId;
  }

  public Follow (Integer userId, Integer followerId) {
    this.userId = userId;
    this.followerId = followerId;
  }
}

