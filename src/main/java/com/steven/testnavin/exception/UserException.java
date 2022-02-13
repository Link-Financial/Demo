package com.steven.testnavin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Server - Problem")
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

}
