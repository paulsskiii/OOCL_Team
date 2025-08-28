package com.group1.capstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PortNotFoundException extends RuntimeException {
    public PortNotFoundException(String message){
        super(message);
    }
}
