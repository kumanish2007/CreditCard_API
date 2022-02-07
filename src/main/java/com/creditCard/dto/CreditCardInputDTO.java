package com.creditCard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CreditCardInputDTO {
    String cardName;
    String cardNumber;
    long limit;
}
