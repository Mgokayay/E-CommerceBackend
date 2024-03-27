package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class RoleException extends RuntimeException{

    private HttpStatus httpStatus;

    public RoleException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
