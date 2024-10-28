package com.project.adoption.pet.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorResponse {
    public static ResponseEntity<Map<String, String>> createErrorResponse(String message, String exceptionName, HttpStatus httpStatus) {
        Map<String, String> map = new HashMap<>();
        map.put(Constants.MESSAGE, message);
        map.put(Constants.KEY_NAME_EXCEPTION, exceptionName);
        return ResponseEntity.status(httpStatus).body(map);
    }
}
