package com.raincur.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId, Throwable cause){
        super(String.format("The user with id '%s' NOT FOUND!", userId), cause);
    }
}
