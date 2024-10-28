package com.project.adoption.pet.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static com.project.adoption.pet.util.ErrorResponse.createErrorResponse;

@ControllerAdvice
public class ControllerAdvisorInfra {

    @ExceptionHandler(InternalErrorInPetTypeException.class)
    public ResponseEntity<Map<String, String>> internalErrorInPetTypeException(InternalErrorInPetTypeException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotCommunicateWithPetTypeException.class)
    public ResponseEntity<Map<String, String>> notCommunicateWithPetTypeException(NotCommunicateWithPetTypeException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(PetNotDeleteException.class)
    public ResponseEntity<Map<String, String>> petNotDeleteException(PetNotDeleteException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<Map<String, String>> petNotFoundException(PetNotFoundException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PetNotGetException.class)
    public ResponseEntity<Map<String, String>> petNotGetException(PetNotGetException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PetNotSaveException.class)
    public ResponseEntity<Map<String, String>> petNotSaveException(PetNotSaveException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PetNotUpdatedException.class)
    public ResponseEntity<Map<String, String>> petNotUpdatedException(PetNotUpdatedException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PetsAvailabilityNotGetException.class)
    public ResponseEntity<Map<String, String>> petsAvailabilityNotGetException(PetsAvailabilityNotGetException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PetsNotGetException.class)
    public ResponseEntity<Map<String, String>> petsNotGetException(PetsNotGetException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
