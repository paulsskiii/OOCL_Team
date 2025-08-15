package com.w2g4.w2g4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrackingEventNotFoundException extends RuntimeException {
    public TrackingEventNotFoundException(String message) {
        super(message);
    }
}
