package com.creditCard.dto;

import lombok.Data;


@Data
public class CreditCardDTO {
    String cardName;
    String cardNumber;
    long limit;
    long balance;
}
