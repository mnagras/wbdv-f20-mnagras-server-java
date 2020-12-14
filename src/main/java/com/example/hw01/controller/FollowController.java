package com.example.hw01.controller;

import com.example.hw01.models.Follow;
import com.example.hw01.models.Review;
import com.example.hw01.services.FollowService;
import com.example.hw01.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class FollowController {
  @Autowired
  FollowService service;

  @GetMapping ("/followers/{userId}")
  public List<Follow> findFollowersById(@PathVariable ("userId") Integer userId) {
    return service.findFollowersById(userId);
  }

  @GetMapping ("/following/{userId}")
  public List<Follow> findFollowingById(@PathVariable ("userId") Integer userId) {
    return service.findFollowingById(userId);
  }

  @PostMapping ("/followers")
  public List<Follow> addFollow(@RequestBody Follow follow) {
    service.createFollow(follow);
    return service.findFollowingById(follow.getFollowerId());
  }

  @DeleteMapping ("/followers")
  public List<Follow> removeFollower(@RequestBody Follow follow) {
    service.removeFollow(follow);
    return service.findFollowingById(follow.getFollowerId());
  }
}
