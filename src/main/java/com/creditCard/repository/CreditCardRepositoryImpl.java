package com.creditCard.repository;

import com.creditCard.entity.CreditCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CreditCardRepositoryImpl implements CreditCardRepository{

   @Autowired
   CreditCardDAO creditCardDAO;

    @Override
    public CreditCard addCreditCard(CreditCard creditCard) {
        log.info("Entered in addCreditCard() method in CreditCardRepositoryImpl");
        return creditCardDAO.save(creditCard);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        log.info("Entered in getAllCreditCards() method in CreditCardRepositoryImpl");
        return creditCardDAO.findAll();
    }
}
