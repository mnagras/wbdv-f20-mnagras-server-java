package com.example.hw01.repositories;

import com.example.hw01.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository  extends CrudRepository<Review, Integer> {
  @Query (value = "SELECT * FROM reviews inner join users on users.user_id = reviews.user_id " +
      "where reviews.product_id=:pid order by reviews.date desc", nativeQuery=true)
  public List<Review> findReviewsByProductId(@Param ("pid") Long pid);
}