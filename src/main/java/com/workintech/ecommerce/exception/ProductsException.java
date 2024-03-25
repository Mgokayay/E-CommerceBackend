package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductsException extends RuntimeException{

    private HttpStatus httpStatus;

    public ProductsException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
