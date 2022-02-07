package com.creditCard.exception;

public class CreditCardNumberNotValidException extends RuntimeException{
    public CreditCardNumberNotValidException(String number) {
        super("Credit Card number "+number+" is Invalid" );
    }
}
