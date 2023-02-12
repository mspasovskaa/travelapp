package com.travelapp.model.exceptions;

public class LocationNotFoundException extends RuntimeException{

  public LocationNotFoundException() {
    super("Location with the given id was not found.");
  }
}
