package com.steven.testnavin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
public class GetUserException extends RuntimeException {

    public GetUserException(String message) {
        super(message);
    }

}
