package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductException extends RuntimeException{

    private HttpStatus httpStatus;

    public ProductException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
