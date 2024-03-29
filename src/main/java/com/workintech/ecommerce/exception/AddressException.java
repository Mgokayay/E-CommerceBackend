package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class AddressException extends RuntimeException{

    private HttpStatus httpStatus;

    public AddressException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
