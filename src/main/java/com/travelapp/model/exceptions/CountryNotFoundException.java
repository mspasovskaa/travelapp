package com.travelapp.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException() {
        super("Country with the given id was not found.");
    }
}
