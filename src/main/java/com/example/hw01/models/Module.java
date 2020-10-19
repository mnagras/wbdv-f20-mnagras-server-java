package com.example.hw01.models;

import java.util.List;

public class Module {
  private int moduleId;
  private String title;
  private List<Lesson> lessonList;

  public Module () {
  }

  public Module (int moduleId, String title) {
    this.moduleId = moduleId;
    this.title = title;
  }

  public int getModuleId () {
    return moduleId;
  }

  public void setModuleId (int courseId) {
    this.moduleId = moduleId;
  }

  public String getTitle () {
    return title;
  }

  public void setTitle (String title) {
    this.title = title;
  }

}
