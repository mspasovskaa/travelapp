package com.travelapp.model.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("Category with the given id was not found.");
    }
}
