package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.hw01.models.Course;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
  static List<Course> courses = new ArrayList<Course>();
  static {
    courses.add(new Course(123, "CS4550", "me", "09/21/2020", "10:05am"));
    courses.add(new Course(234, "CS5610", "me", "09/21/2020", "10:05am"));
    courses.add(new Course(543, "CS3200", "me", "today", "10:05am"));
    courses.add(new Course(456, "CS2510", "me", "yesterday", "10:05am"));
  }

  @GetMapping("/courses")
  public List<Course> findAllcourses() {
    return courses;
  }

  @PostMapping("/courses")
  public List<Course> createCourse(@RequestBody Course course) {
    courses.add(course);
    return courses;
  }

  @DeleteMapping("/courses/{courseId}")
  public List<Course> deleteCourse(@PathVariable int courseId) {
    Course u = null;
    for(Course course:courses) {
      if(course.getCourseId() == courseId) {
        u = course;
      }
    }
    courses.remove(u);
    return courses;
  }

  @PutMapping
  public List<Course> updateCourse(@RequestBody Course course) {
    for (int i=0; i<courses.size(); i++) {
      int courseId = courses.get(i).getCourseId();
      if (course.getCourseId() == courseId) {
        courses.remove(i);
        courses.add(i, course);
        break;
      }
    }
    return courses;
  }

  @GetMapping("/course/{courseId}")
  public Course findCourseById(int courseId) {
    Course u = null;
    for(Course course:courses) {
      if(course.getCourseId() == courseId) {
        return course;
      }
    }
    return u;
  }
}


