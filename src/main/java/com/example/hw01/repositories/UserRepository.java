package com.example.hw01.repositories;

import com.example.hw01.models.User;
import com.example.hw01.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends CrudRepository<User, Integer> {

}
