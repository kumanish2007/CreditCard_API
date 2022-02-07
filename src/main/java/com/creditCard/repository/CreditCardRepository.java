package com.creditCard.repository;

import com.creditCard.entity.CreditCard;

import java.util.List;

public interface CreditCardRepository {

    public CreditCard addCreditCard(CreditCard creditCard);

    public List<CreditCard> getAllCreditCards();
}
