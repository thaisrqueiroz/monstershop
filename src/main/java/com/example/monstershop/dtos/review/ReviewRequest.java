package com.example.monstershop.dtos.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReviewRequest(
        Long id,
        Long productId,
        @NotBlank(message = "Username is required")
        @Size(min = 5, max = 50, message = "Username must contain minimum 5 and maximum 50 characters")
        String username,
        @NotNull(message = "Rating is required")
        double rating,
        @Size(min = 10, max = 250, message = "Review must contain minimum 10 and maximum 250 characters")
        String body
) {
}