package com.example.hw01.services;

import com.example.hw01.models.Review;
import com.example.hw01.models.User;
import com.example.hw01.models.Widget;
import com.example.hw01.repositories.UserRepository;
import com.example.hw01.repositories.ReviewRepository;
import com.example.hw01.repositories.FollowRepository;

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
  @Autowired
  ReviewRepository reviewRepository;
  @Autowired
  FollowRepository followRepository;


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
    //Remove from Reviews Table
      reviewRepository.deleteReviewsByUserId(userId);
    //Remove from follow
    followRepository.deleteFollowingById(userId);
    followRepository.deleteFollowersById(userId);
    userRepository.deleteById(userId);
  }

  public User updateUser (Integer userId, User newUser) {
    return userRepository.save(newUser);
  }

  public User findUserByEmail (String email) {
    return userRepository.findUserByEmail(email);
  }

  public List<User> findAllRecentUsers () {
    return userRepository.findRecentUsers();
  }
}
