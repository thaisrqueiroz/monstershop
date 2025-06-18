package com.example.monstershop.services;

import com.example.monstershop.dtos.review.ReviewMapper;
import com.example.monstershop.dtos.review.ReviewRequest;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;
import com.example.monstershop.repositories.ProductRepository;
import com.example.monstershop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ReviewService(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public List<ReviewResponse> getReviews(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found"));
        return product.getReviews().stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest){
        Product product = productRepository.findById(reviewRequest.productId()).orElseThrow(() -> new NoSuchElementException("Product not found"));
        Review newReview = ReviewMapper.dtoToEntity(product, reviewRequest);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);
    }
}