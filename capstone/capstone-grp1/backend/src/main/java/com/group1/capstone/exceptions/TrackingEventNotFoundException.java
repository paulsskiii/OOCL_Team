package com.group1.capstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrackingEventNotFoundException extends RuntimeException {
    public TrackingEventNotFoundException(String message) {
        super(message);
    }
}
