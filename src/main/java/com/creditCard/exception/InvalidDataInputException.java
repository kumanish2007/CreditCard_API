package com.creditCard.exception;

public class InvalidDataInputException extends RuntimeException{
    public InvalidDataInputException(){
        super("Entered inputs is invalid");
    }
}
