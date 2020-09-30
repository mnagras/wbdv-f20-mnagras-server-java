package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.hw01.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  static List<User> users = new ArrayList<User>();
  static {
    users.add(new User(123, "mnagras", "Manami", "Nagras"));
    users.add(new User(234, "bsnow", "Bill", "Snow"));
    users.add(new User(543, "dnilange", "Deepa", "Nilange"));
    users.add(new User(456, "mina", "Mina", "Kumar"));
  }

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return users;
  }

  @PostMapping("/users")
  public List<User> createUser(@RequestBody User user) {
    users.add(user);
    return users;
  }

  @DeleteMapping("/users/{userId}")
  public List<User> deleteUser(@PathVariable int userId) {
    User u = null;
    for(User user:users) {
      if(user.getUserId() == userId) {
        u = user;
      }
    }
    users.remove(u);
    return users;
  }




}
