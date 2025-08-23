package com.example.cargoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CargoNotFoundException extends RuntimeException {
    public CargoNotFoundException(String message) {super(message);
    }
}
