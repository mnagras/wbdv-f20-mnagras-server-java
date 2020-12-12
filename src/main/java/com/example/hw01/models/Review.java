package com.example.hw01.models;

import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "reviews")
public class Review {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer reviewId;
  private Integer userId;
  private Long productId;
  private String date;
  private String comment;
  private boolean bLike;
  @Column (insertable=false, updatable=false)
  private String firstName;
  @Column(insertable=false, updatable=false)
  private String lastName;

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

  public Integer getReviewId () {
    return reviewId;
  }

  public void setReviewId (Integer reviewId) {
    this.reviewId = reviewId;
  }

  public Integer getUserId () {
    return userId;
  }

  public void setUserId (Integer userId) {
    this.userId = userId;
  }

  public Long getProductId () {
    return productId;
  }

  public void setProductId (Long productId) {
    this.productId = productId;
  }

  public String getDate () {
    return date;
  }

  public void setDate (String date) {
    this.date = date;
  }

  public String getComment () {
    return comment;
  }

  public void setComment (String comment) {
    this.comment = comment;
  }

  public boolean isbLike () {
    return bLike;
  }

  public void setbLike (boolean bLike) {
    this.bLike = bLike;
  }

  public Review () {
  }

  public Review (Integer reviewId, Integer userId, Long productId, String date, String comment, boolean bLike) {
    this.reviewId = reviewId;
    this.userId = userId;
    this.productId = productId;
    this.date = date;
    this.comment = comment;
    this.bLike = bLike;
  }
}
