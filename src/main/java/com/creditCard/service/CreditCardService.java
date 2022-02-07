package com.creditCard.service;

import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.response.SaveResponseDTO;

import java.util.List;

public interface CreditCardService {

    /**
     * @param creditCardInputDTO
     */
    public SaveResponseDTO addCreditCard(CreditCardInputDTO creditCardInputDTO);


    /**
     * @return list of creditCard
     */
    public List<CreditCardDTO> getCreditCard();
}
