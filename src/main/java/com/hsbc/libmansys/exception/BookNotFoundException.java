package com.hsbc.libmansys.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn){
        super(String.format("There is no books for isbn  %s",isbn));
    }
}
