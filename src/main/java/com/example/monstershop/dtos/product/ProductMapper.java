package com.example.monstershop.dtos.product;

import com.example.monstershop.models.Product;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto) {
        return new Product(dto.name(), dto.price(), dto.imageUrl(), dto.rating(), dto.reviewCount(), dto.featured());
    }

    public static ProductResponse entityToDto (Product product){
        return new ProductResponse(product.getName(), product.getPrice(), product.getImageUrl(), product.getRating(), product.getReviewCount(), product.getFeatured());
    }
}