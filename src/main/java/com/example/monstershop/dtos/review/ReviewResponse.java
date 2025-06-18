package com.example.monstershop.dtos.review;

public record ReviewResponse(
        Long productId,
        Long id,
        String username,
        double rating,
        String body
) {
}