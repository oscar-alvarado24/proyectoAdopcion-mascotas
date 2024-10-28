package com.project.adoption.pet.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static com.project.adoption.pet.util.ErrorResponse.createErrorResponse;
@ControllerAdvice
public class ControllerAdvisorApp {



    @ExceptionHandler(PetTypeNotExistException.class)
    public ResponseEntity<Map<String, String>> petTypeNotExist(PetTypeNotExistException ex) {
        return createErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), HttpStatus.NOT_FOUND);
    }
}
