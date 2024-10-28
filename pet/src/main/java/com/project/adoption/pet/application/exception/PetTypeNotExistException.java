package com.project.adoption.pet.application.exception;

public class PetTypeNotExistException extends RuntimeException {
    public PetTypeNotExistException(String message) {
        super(message);
    }
}
