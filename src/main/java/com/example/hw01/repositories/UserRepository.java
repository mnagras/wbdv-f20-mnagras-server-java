package com.example.hw01.repositories;

import com.example.hw01.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends CrudRepository<User, Integer> {
  @Query(value = "SELECT * FROM users where email=:email", nativeQuery=true)
  public User findUserByEmail(@Param("email") String email);
}


