package com.group1.capstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// RuntimeException is unchecked → cleaner code, better for business logic errors in Spring APIs.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CargoNotFoundException extends RuntimeException {
    public CargoNotFoundException(String message) {
        super(message);
    }
}
