package com.example.hw01.models;

import java.util.List;

public class Lesson {
  private int lessonId;
  private String lessonTitle;
  private List<Topic> topicList;

  public Lesson () {}

  public int getLessonId () {
    return lessonId;
  }

  public void setLessonId (int lessonId) {
    this.lessonId = lessonId;
  }

  public String getLessonTitle () {
    return lessonTitle;
  }

  public void setLessonTitle (String lessonTitle) {
    this.lessonTitle = lessonTitle;
  }

  public Lesson (int lessonId, String lessonTitle) {
    this.lessonId = lessonId;
    this.lessonTitle = lessonTitle;
  }
}




