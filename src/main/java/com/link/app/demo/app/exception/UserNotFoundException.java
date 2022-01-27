package com.link.app.demo.app.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("There is no user with given id");
    }
}
