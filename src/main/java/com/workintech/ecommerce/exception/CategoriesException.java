package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class CategoriesException extends RuntimeException{

    private HttpStatus httpStatus;

    public CategoriesException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
