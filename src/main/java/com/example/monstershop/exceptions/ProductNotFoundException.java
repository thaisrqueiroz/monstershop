package com.example.monstershop.exceptions;

public class ProductNotFoundException extends AppException {
    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found.");
    }
}
