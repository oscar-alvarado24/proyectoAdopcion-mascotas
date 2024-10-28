package com.project.adoption.pet.infrastructure.exceptions;

public class PetNotDeleteException extends RuntimeException {
    public PetNotDeleteException(String message) {
        super(message);
    }
}
