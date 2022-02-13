package com.steven.testnavin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Payload - Problem")
public class PayloadUserException extends RuntimeException {

    public PayloadUserException(String message) {
        super(message);
    }

}
