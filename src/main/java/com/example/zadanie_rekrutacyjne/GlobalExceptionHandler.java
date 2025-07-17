package com.example.zadanie_rekrutacyjne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException responseStatusException) {
        return ResponseEntity
                .status(responseStatusException.getStatusCode())
                .body(Map.of(
                   "status", responseStatusException.getStatusCode().value(),
                   "message", responseStatusException.getReason()
                ));
    }
}
