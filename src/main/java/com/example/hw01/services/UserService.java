package com.example.hw01.services;

import com.example.hw01.models.User;
import com.example.hw01.models.Widget;
import com.example.hw01.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  List<User> userList = new ArrayList<User>();


  public List<User> findAllUsers () {
    return (List<User>) userRepository.findAll();

  }


  public User findUserById (Integer userId) {
    return userRepository.findById(userId).get();

  }

  public User createUser (User user) {
    return userRepository.save(user);

  }

  public void deleteUser (Integer userId) {
    userRepository.deleteById(userId);


  }

  public User updateUser (Integer userId, User newUser) {
    User user = userRepository.findById(userId).get();
    user.setFirstName(newUser.getFirstName());
    user.setLastName(newUser.getLastName());
    return userRepository.save(newUser);
    /*
    for (int i=0; i<widgetList.size(); i++) {
    Widget w = widgetList.get(i);
      if (w.getId() == (widgetId)) {
        widgetList.remove(i);
        widgetList.add(i, newWidget);
        return 1;
      }
    }
    return 0;

     */
  }

  public User findUserByEmail (String email) {
    return userRepository.findUserByEmail(email);
  }
}
