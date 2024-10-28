package com.project.adoption.pet.infrastructure.exceptions;

public class PetNotUpdatedException extends RuntimeException {
    public PetNotUpdatedException(String message) {
        super(message);
    }
}
