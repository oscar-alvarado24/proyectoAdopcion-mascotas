package com.project.adoption.pet.infrastructure.exceptions;

public class PetNotSaveException extends RuntimeException {
    public PetNotSaveException(String message) {
        super(message);
    }
}
