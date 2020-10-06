package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.example.hw01.models.Course;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courses")
public class CourseController {
  static List<Course> courses = new ArrayList<Course>();
  static {
    courses.add(new Course((int) (new Date()).getTime(), "CS4550", "me", "09/21/2020", "10:05am"));
    courses.add(new Course((int) (new Date()).getTime() + 1, "CS5610", "me", "09/21/2020", "10:05am"));
    courses.add(new Course((int) (new Date()).getTime() + 2, "CS3200", "me", "today", "10:05am"));
    courses.add(new Course((int) (new Date()).getTime() + 3, "CS2510", "me", "yesterday", "10:05am"));
  }

  @GetMapping("")
  public List<Course> findAllcourses() {
    return courses;
  }

  @PostMapping("")
  public List<Course> createCourse(@RequestBody Course course) {
    course.setCourseId((int) (new Date()).getTime());
    courses.add(course);
    return courses;
  }

  @DeleteMapping("/{courseId}")
  public List<Course> deleteCourse(@PathVariable int courseId) {
    Course u = null;
    for(Course course:courses) {
      if(course.getCourseId() == courseId) {
        u = course;
        courses.remove(u);
        break;
      }
    }
    return courses;
  }

  @PutMapping
  public List<Course> updateCourse(@RequestBody Course course) {
    for (int i=0; i<courses.size(); i++) {
      int courseId = courses.get(i).getCourseId();
      if (course.getCourseId() == courseId) {
        courses.remove(i);
        courses.add(i, course);
        System.out.println("Updated course title:" + course.getTitle());
        break;
      }
    }
    return courses;
  }


  @GetMapping("/{courseId}")
  public Course findCourseById(@PathVariable int courseId) {
    Course u = null;
    for(Course course:courses) {
      if(course.getCourseId() == courseId) {
        return course;
      }
    }
    return u;
  }
}


