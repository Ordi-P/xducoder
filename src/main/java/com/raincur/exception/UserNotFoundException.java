package com.raincur.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId){
        super(String.format("The user with id '%s' NOT FOUND!", userId));
    }
}
