package com.example.monstershop.dtos.review;

import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity (Product product, ReviewRequest dto) {
        return new Review(product, dto.id(), dto.username(), dto.rating(), dto.body());
    }

    public static ReviewResponse entityToDto (Review review) {
        Long productId = review.getProduct().getId();
        return new ReviewResponse(productId, review.getId(), review.getUsername(), review.getRating(), review.getBody());
    }
}