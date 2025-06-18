package com.example.monstershop.services;

import com.example.monstershop.dtos.review.ReviewMapper;
import com.example.monstershop.dtos.review.ReviewRequest;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Review;
import com.example.monstershop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewResponse> getReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest){
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);
    }
}