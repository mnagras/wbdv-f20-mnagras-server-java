package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.hw01.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  static List<User> users = new ArrayList<User>();
  static {
    users.add(new User(123, "mnagras", "Manami", "Nagras", "Student"));
    users.add(new User(234, "bsnow", "Bill", "Snow", "Student"));
    users.add(new User(543, "dnilange", "Deepa", "Nilange", "Admin"));
    users.add(new User(456, "mina", "Mina", "Kumar", "Student"));
  }

  @GetMapping("")
  public List<User> findAllUsers() {
    return users;
  }

  @PostMapping("")
  public List<User> createUser(@RequestBody User user) {
    users.add(user);
    return users;
  }

  @DeleteMapping("/{userId}")
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

  @PutMapping
  public List<User> updateUser(@RequestBody User user) {
    for (int i=0; i<users.size(); i++) {
      int userId = users.get(i).getUserId();
      if (user.getUserId() == userId) {
        users.remove(i);
        users.add(i, user);
        break;
      }
    }
    return users;
  }
}
