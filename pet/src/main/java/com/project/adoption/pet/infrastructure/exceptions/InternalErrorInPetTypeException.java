package com.project.adoption.pet.infrastructure.exceptions;

public class InternalErrorInPetTypeException extends RuntimeException {
    public InternalErrorInPetTypeException(String message) {
        super(message);
    }
}
