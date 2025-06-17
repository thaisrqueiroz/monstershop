package com.example.monstershop.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 5, max = 50, message = "Name must contain minimum 5 and maximo 50 characters")
        String name,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
) {
}