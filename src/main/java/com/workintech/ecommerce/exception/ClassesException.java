package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ClassesException extends RuntimeException{

    private HttpStatus httpStatus;

    public ClassesException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }
}
