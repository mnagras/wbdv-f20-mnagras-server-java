package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.example.hw01.models.Course;
import com.example.hw01.models.Module;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courses")
public class CourseController {
  static List<Course> courses = new ArrayList<Course>();

  static {
    List<Module> module1 = new ArrayList<Module>();
    module1.add(new Module((int) (new Date()).getTime(), "Module 1"));
    module1.add(new Module((int) (new Date()).getTime() + 1, "Module 2"));
    module1.add(new Module((int) (new Date()).getTime() + 2, "Module 3"));

    List<Module> module2 = new ArrayList<Module>();
    module2.add(new Module((int) (new Date()).getTime(), "Module 1"));
    module2.add(new Module((int) (new Date()).getTime() + 1, "Module 2"));
    module2.add(new Module((int) (new Date()).getTime() + 2, "Module 3"));

    List<Module> module3 = new ArrayList<Module>();
    module3.add(new Module((int) (new Date()).getTime(), "Module 1"));
    module3.add(new Module((int) (new Date()).getTime() + 1, "Module 2"));
    module3.add(new Module((int) (new Date()).getTime() + 2, "Module 3"));

    List<Module> module4 = new ArrayList<Module>();
    module4.add(new Module((int) (new Date()).getTime(), "Module 1"));
    module4.add(new Module((int) (new Date()).getTime() + 1, "Module 2"));
    module4.add(new Module((int) (new Date()).getTime() + 2, "Module 3"));


    courses.add(new Course((int) (new Date()).getTime(), "CS4550", "me", "09/21/2020", "10:05am", module1));
    courses.add(new Course((int) (new Date()).getTime() + 1, "CS5610", "me", "09/21/2020", "10:05am", module2));
    courses.add(new Course((int) (new Date()).getTime() + 2, "CS3200", "me", "today", "10:05am", module3));
    courses.add(new Course((int) (new Date()).getTime() + 3, "CS2510", "me", "yesterday", "10:05am", module4));
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

  @PostMapping("/{courseId}")
  public List<Module> createModuleForCourse(@PathVariable int courseId, @RequestBody Module module) {
    for (Course course : courses) {
      if (course.getCourseId() == courseId) {
        course.addModule(module);
        return course.getModuleList();
      }
    }
    return null;
  }


  @GetMapping("/{courseId}/modules")
  public List<Module> findModulesforCourse(@PathVariable int courseId) {
    for(Course course:courses) {
      if(course.getCourseId() == courseId) {
        return course.getModuleList();
      }
    }
    return null;
  }
}





