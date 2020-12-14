package com.example.hw01.controller;

import com.example.hw01.models.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hw01.models.User;
import com.example.hw01.services.ReviewService;
import com.example.hw01.services.UserService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class ReviewController {
  @Autowired
  ReviewService service;

  @GetMapping ("/reviews/{productId}")
  public List<Review> findReviewsByProductId(@PathVariable ("productId") String strProductId) {
    Long productId = Long.parseLong(strProductId);
    return service.findProductReviews(productId);
  }

  @GetMapping ("/reviews/recent")
  public List<Review> findRecentReviews() {
    return service.findRecentReviews();
  }

  @GetMapping ("/reviews/user/{userId}")
  public List<Review> findReviewsByUserId(@PathVariable ("userId") String strUserId) {
    System.out.println("Reviews for User in" + strUserId);
    int userId = Integer.parseInt(strUserId);
    return service.findUserReviews(userId);
  }

  @PostMapping ("/reviews")
  public List<Review> addReview(@RequestBody Review review) {
    service.createReview(review);
    return service.findProductReviews(review.getProductId());
  }
}

