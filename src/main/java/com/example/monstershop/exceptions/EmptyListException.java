package com.example.monstershop.exceptions;

public class EmptyListException extends AppException {
    public EmptyListException() {
        super("The list is empty.");
    }
}
