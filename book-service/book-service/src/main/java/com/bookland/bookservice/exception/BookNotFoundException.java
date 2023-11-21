package com.bookland.bookservice.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String s){
        super(s);

    }
}
