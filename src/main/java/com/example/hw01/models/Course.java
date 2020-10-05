package com.example.hw01.models;

public class Course {
  private int courseId;
  private String title;
  private String owner;
  private String dateModified;
  private String timeModified;

  public Course () {
  }

  public Course (int courseId, String title, String owner, String dateModified, String timeModified) {
    this.courseId = courseId;
    this.title = title;
    this.owner = owner;
    this.dateModified = dateModified;
    this.timeModified = timeModified;
  }

  public int getCourseId () {
    return courseId;
  }

  public void setCourseId (int courseId) {
    this.courseId = courseId;
  }

  public String getTitle () {
    return title;
  }

  public void setTitle (String title) {
    this.title = title;
  }

  public String getOwner () {
    return owner;
  }

  public void setOwner (String owner) {
    this.owner = owner;
  }

  public String getDateModified () {
    return dateModified;
  }

  public void setDateModified (String dateModified) {
    this.dateModified = dateModified;
  }

  public String getTimeModified () {
    return timeModified;
  }

  public void setTimeModified (String timeModified) {
    this.timeModified = timeModified;
  }
}
