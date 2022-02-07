package com.creditCard.controller;

import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.response.SaveResponseDTO;
import com.creditCard.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/creditCard")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    /**
     * @param creditCardInputDTO the creditCardInputDTO
     * @return the save response DTO after successfully save the record.
     */
    @PostMapping("/addCreditCard")
    public SaveResponseDTO addCreditCardInfo(@RequestBody CreditCardInputDTO creditCardInputDTO) {
        log.info("Entered in addCreditCardInfo method");
        SaveResponseDTO saveResponseDTO = creditCardService.addCreditCard(creditCardInputDTO);
        log.info("Exit from addCreditCardInfo method");
        return saveResponseDTO;
    }

    /**
     * @return the list of credit cards
     */
    @GetMapping("/getCreditCardList")
    public List<CreditCardDTO> getCreditCardList() {
        log.info("Entered in getCreditCardList method");
        List<CreditCardDTO> creditCardDTOList = creditCardService.getCreditCard();
        log.info("Exit from getCreditCardList method");
        return creditCardDTOList;
    }

}
