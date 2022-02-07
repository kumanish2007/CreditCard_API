package com.creditCard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CreditCardControllerAdvice{

    @ExceptionHandler(CreditCardNumberNotValidException.class)
    public ResponseEntity<?> creditCardNotValidHandler(CreditCardNumberNotValidException ex, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setLocalDate(LocalDateTime.now());
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> NoRecordFoundHandler(DataNotFoundException ex, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setLocalDate(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataInputException.class)
    public ResponseEntity<?> invalidDataInputExceptions(InvalidDataInputException ex, WebRequest webRequest) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(ex.getMessage());
        response.setLocalDate(LocalDateTime.now());
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
