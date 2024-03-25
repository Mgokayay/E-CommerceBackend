package com.workintech.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@AllArgsConstructor
@Data
public class ErrorResponse {

    private int status;
    private String message;
    private Instant timestamp;
}
