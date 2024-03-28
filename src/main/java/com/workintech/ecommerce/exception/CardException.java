package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class CardException extends RuntimeException{

    private HttpStatus httpStatus;

    public CardException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
