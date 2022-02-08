package com.creditCard.builder;

import com.creditCard.entity.CreditCard;

public class CreditCardBuilder {
    private CreditCard creditCard;

    public CreditCardBuilder() {
        this.creditCard = new CreditCard();
    }

    public CreditCardBuilder withCreditCardNumber(String cardNumber){
        this.creditCard.setCardNumber(cardNumber);
        return this;
    }

    public CreditCardBuilder withCreditCardName(String name){
        this.creditCard.setCardName(name);
        return this;
    }

    public CreditCardBuilder withCreditCardLimit(long limit){
        this.creditCard.setCardLimit(limit);
        return this;
    }

    public CreditCardBuilder withCreditBalance(long balance){
        this.creditCard.setBalance(balance);
        return this;
    }

    public CreditCard build(){
        return creditCard;
    }
}
