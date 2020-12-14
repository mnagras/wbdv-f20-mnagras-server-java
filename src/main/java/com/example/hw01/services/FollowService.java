package com.example.hw01.services;

import com.example.hw01.models.Follow;
import com.example.hw01.repositories.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
  @Autowired
  FollowRepository followRepository;

  public List<Follow> findFollowersById (Integer userId) {
    return followRepository.findFollowersById(userId);
  }

  public List<Follow> findFollowingById (Integer userId) {
    return followRepository.findFollowingById(userId);
  }

  public Follow createFollow (Follow follow) {
    return followRepository.save(follow);
  }

  public void removeFollow (Follow follow) {
    Follow follow1 = followRepository.findFollowByBothIds(follow.getUserId(), follow.getFollowerId());
    followRepository.deleteById(follow1.getFollowId());
  }

  public void removeFollower (int followId) {
    followRepository.deleteById(followId);
  }
}
