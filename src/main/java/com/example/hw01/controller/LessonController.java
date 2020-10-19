package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.example.hw01.models.Lesson;

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
@RequestMapping("/{courseId}/{moduleId}/lessons")
public class LessonController {
  static List<Lesson> lessons = new ArrayList<Lesson>();
  static {
    lessons.add(new Lesson((int) (new Date()).getTime(), "Lesson 1"));
    lessons.add(new Lesson((int) (new Date()).getTime() + 1, "Lesson 2"));
    lessons.add(new Lesson((int) (new Date()).getTime() + 2, "Lesson 3"));
    lessons.add(new Lesson((int) (new Date()).getTime() + 3, "Lesson 4"));
  }

  @GetMapping("")
  public List<Lesson> findAllLessons() {
    return lessons;
  }

  @PostMapping("")
  public List<Lesson> createLesson(@RequestBody Lesson lesson) {
    lesson.setLessonId((int) (new Date()).getTime());
    lessons.add(lesson);
    return lessons;
  }

  @DeleteMapping("/{lessonId}")
  public List<Lesson> deleteLesson(@PathVariable int lessonId) {
    Lesson u = null;
    for(Lesson lesson:lessons) {
      if(lesson.getLessonId() == lessonId) {
        u = lesson;
        lessons.remove(u);
        break;
      }
    }
    return lessons;
  }

  @PutMapping
  public List<Lesson> updateLesson(@RequestBody Lesson lesson) {
    for (int i=0; i<lessons.size(); i++) {
      int lessonId = lessons.get(i).getLessonId();
      if (lesson.getLessonId() == lessonId) {
        lessons.remove(i);
        lessons.add(i, lesson);
        //System.out.println("Updated module title:" + module.getTitle());
        break;
      }
    }
    return lessons;
  }


  @GetMapping("/{lessonId}")
  public Lesson findLessonById(@PathVariable int lessonId) {
    Lesson u = null;
    for(Lesson lesson:lessons) {
      if(lesson.getLessonId() == lessonId) {
        return lesson;
      }
    }
    return u;
  }
}




