package com.example.hw01.repositories;

import com.example.hw01.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ReviewRepository  extends CrudRepository<Review, Integer> {
  @Query (value = "SELECT * FROM reviews inner join users on users.user_id = reviews.user_id " +
      "where reviews.product_id=:pid order by reviews.date desc", nativeQuery=true)
  public List<Review> findReviewsByProductId(@Param("pid")Long pid);

  @Query (value = "SELECT * FROM reviews inner join users on users.user_id = reviews.user_id " +
      "where reviews.user_id=:uid order by reviews.date desc", nativeQuery=true)
  public List<Review> findReviewsByUserId (@Param("uid")int userId);

  @Query(value = "SELECT * FROM reviews inner join users on users.user_id = reviews.user_id " +
      "where reviews.date >= CURDATE() -  1 order by reviews.date desc",
      nativeQuery=true)
  public List<Review> findRecentReviews();

  @Query (value = "Delete * FROM reviews inner join users on users.user_id = reviews.user_id " +
      "where reviews.user_id=:uid ", nativeQuery=true)
  public void deleteReviewsByUserId (@Param("uid")int userId);


}