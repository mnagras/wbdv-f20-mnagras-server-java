package com.example.hw01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.example.hw01.models.User;

import com.example.hw01.models.Widget;
import com.example.hw01.services.UserService;
import com.example.hw01.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin (origins = "*")

public class UserController {
  static List<User> users = new ArrayList<User>();
  static {
    users.add(new User(123, "Manami", "Nagras", "mnagras@northeastern.edu", "123345322", "350 Huntington Avenue", "Customer", "dhfkuo1234"));
    users.add(new User(234, "Bill", "Snow", "bsnow@hotmail.com", "3456789458", "50 Leon Street", "Customer", "dhfkuo1234"));
    users.add(new User(543, "Deepa", "Nilange", "dnilange@gmail.com", "2445534567", "", "Admin", "dhfkuo1234"));
    users.add(new User(456, "Mina", "Kumar", "mkumar@gmail.com", "3452345678", "", "Admin", "dhfkuo1234"));
  }
  @Autowired
  UserService service;

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return service.findAllUsers();
  }

  @GetMapping("/users/{userId}")
  public User findUserById(@PathVariable("userId") Integer userId) {
    return service.findUserById(userId);
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
    user.setUserId((int) (new Date()).getTime());
    return service.createUser(user);
  }

  @DeleteMapping("/users/{userId}")
  public void deleteUser(@PathVariable int userId) {
    service.deleteUser(userId);
    /*
    User u = null;
    for(User user:users) {
      if(user.getUserId() == userId) {
        u = user;
      }
    }
    users.remove(u);
    return users;*/
  }

  @PutMapping("/users/{userId}")
  public User updateUser(@PathVariable("uid") Integer userId, @RequestBody User newUser) {
    return service.updateUser(userId, newUser);
    /*
    for (int i=0; i<users.size(); i++) {
      int userId = users.get(i).getUserId();
      if (user.getUserId() == userId) {
        users.remove(i);
        users.add(i, user);
        break;
      }
    }
    return users;
    */

  }
}
