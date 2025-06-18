package com.example.monstershop.controllers;

import com.example.monstershop.dtos.review.ReviewRequest;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResponse>> getAllReviews() {
        List<ReviewResponse> reviews = reviewService.getReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponse> addReview (@Valid @RequestBody ReviewRequest reviewRequest) {
        ReviewResponse newReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
}