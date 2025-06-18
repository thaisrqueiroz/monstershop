package com.example.monstershop.exceptions;

public class ProductAlreadyExistsException extends AppException {
    public ProductAlreadyExistsException(String productName) {
        super("The product: " + productName + " already exists.");
    }
}
