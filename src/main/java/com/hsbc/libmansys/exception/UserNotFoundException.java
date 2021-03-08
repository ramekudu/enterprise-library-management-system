package com.hsbc.libmansys.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(UUID id){
        super(String.format("There is no books for isbn  %s",id));
    }
}
