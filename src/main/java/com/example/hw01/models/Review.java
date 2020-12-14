package com.example.hw01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  private Timestamp date;
  private String comment;
  private boolean bLike;
  @Column (insertable=false, updatable=false)
  private String firstName;
  @Column(insertable=false, updatable=false)
  private String lastName;

  /*
  @ManyToOne (fetch = FetchType.LAZY, optional = false)
  @JoinColumn (name = "user_id", nullable = false)
  @OnDelete (action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private User user;
*/
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

  public Timestamp getDate () {
    return date;
  }

  public void setDate (Timestamp date) {
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

  public Review () {
  }

  public Review (Integer reviewId, Integer userId, Long productId, Timestamp date, String comment, boolean bLike) {
    this.reviewId = reviewId;
    this.userId = userId;
    this.productId = productId;
    this.date = date;
    this.comment = comment;
    this.bLike = bLike;
  }
}
