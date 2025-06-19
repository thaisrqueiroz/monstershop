package com.example.monstershop.exceptions;

public class DuplicateReviewException extends AppException {
    public DuplicateReviewException(String username, String productName) {
        super("User " + username + " already has a review for the product " + productName);
    }
}
