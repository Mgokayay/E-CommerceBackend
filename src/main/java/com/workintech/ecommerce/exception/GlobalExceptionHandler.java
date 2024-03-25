package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(CategoriesException categoriesException){
        ErrorResponse errorResponse = new ErrorResponse(categoriesException.getHttpStatus().value(),categoriesException.getMessage(),
                Instant.now());
        return new ResponseEntity<>(errorResponse,categoriesException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),
                Instant.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
