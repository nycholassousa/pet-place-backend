package com.petplace.placeservice.exception;

public class PlaceAlreadyExistException extends RuntimeException {
    public PlaceAlreadyExistException(String message) {
        super(message);
    }
}
