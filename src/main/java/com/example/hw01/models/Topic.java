package com.example.hw01.models;

public class Topic {
  private int topicId;
  private String topicTitle;

  public Topic () {
  }

  public Topic (int topicId, String topicTitle) {
    this.topicId = topicId;
    this.topicTitle = topicTitle;
  }

  public int getTopicId () {
    return topicId;
  }

  public void setTopicId (int topicId) {
    this.topicId = topicId;
  }

  public String getTopicTitle () {
    return topicTitle;
  }

  public void setTopicTitle (String topicTitle) {
    this.topicTitle = topicTitle;
  }
}
