package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StoreException extends RuntimeException{

    private HttpStatus httpStatus;

    public StoreException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus=httpStatus;
    }


}
