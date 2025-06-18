package com.example.monstershop.dtos.review;

public record ReviewRequest(
        Long product_id,
        String username,
        double rating,
        String body
) {
}