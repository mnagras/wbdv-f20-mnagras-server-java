package com.example.hw01.repositories;

import com.example.hw01.models.Follow;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, Integer> {
  @Query (value = "SELECT * FROM follows inner join users on users.user_id = follows.follower_id " +
      "where follows.user_id=:userId", nativeQuery=true)
  public List<Follow> findFollowersById(@Param ("userId") Integer userId);

  @Query (value = "SELECT * FROM follows inner join users on users.user_id = follows.user_id " +
      "where follows.follower_id=:userId", nativeQuery=true)
  public List<Follow> findFollowingById(@Param ("userId") Integer userId);

  @Query (value = "SELECT * FROM follows inner join users on users.user_id = follows.user_id " +
      "where follows.user_id=:userId AND follows.follower_id=:followerId", nativeQuery=true)
  public Follow findFollowByBothIds(@Param ("userId") Integer userId, @Param ("followerId") Integer followerId);

  @Query (value = "Delete * FROM follows inner join users on users.user_id = follows.user_id " +
      "where follows.follower_id=:userId", nativeQuery=true)
  public void deleteFollowingById(@Param ("userId") Integer userId);

    @Query (value = "Delete * FROM follows inner join users on users.user_id = follows.follower_id " +
        "where follows.user_id=:userId", nativeQuery=true)
    public void deleteFollowersById(@Param ("userId") Integer userId);
}
