package com.example.hw01.services;

import com.example.hw01.models.Review;
import com.example.hw01.models.User;
import com.example.hw01.repositories.ReviewRepository;
import com.example.hw01.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
  @Autowired
  ReviewRepository reviewRepository;
  List<Review> reviewList = new ArrayList<Review>();

  public List<Review> findProductReviews (Long productId) {
    return reviewRepository.findReviewsByProductId(productId);

  }

  public Review createReview (Review review) {
    return reviewRepository.save(review);

  }

  public void deleteReview (Integer reviewId) {
    reviewRepository.deleteById(reviewId);


  }
}
