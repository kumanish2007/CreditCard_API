package com.creditCard.builder;

import com.creditCard.dto.CreditCardDTO;
import com.creditCard.entity.CreditCard;

public class CreditCardDTOBuilder {
    private CreditCardDTO creditCardDTO;

    public CreditCardDTOBuilder() {
        this.creditCardDTO = new CreditCardDTO();
    }

    public CreditCardDTOBuilder withCreditCardNumber(String cardNumber){
        this.creditCardDTO.setCardNumber(cardNumber);
        return this;
    }

    public CreditCardDTOBuilder withCreditCardName(String name){
        this.creditCardDTO.setCardName(name);
        return this;
    }

    public CreditCardDTOBuilder withCreditCardLimit(long limit){
        this.creditCardDTO.setLimit(limit);
        return this;
    }

    public CreditCardDTOBuilder withCreditBalance(long balance){
        this.creditCardDTO.setBalance(balance);
        return this;
    }

    public CreditCardDTO build(){
        return creditCardDTO;
    }
}
