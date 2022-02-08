package com.creditCard.service;

import com.creditCard.builder.CreditCardBuilder;
import com.creditCard.builder.SaveResponseBuilder;
import com.creditCard.config.AppConstants;
import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.entity.CreditCard;
import com.creditCard.exception.*;
import com.creditCard.repository.CreditCardRepository;
import com.creditCard.response.SaveResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public SaveResponseDTO addCreditCard(CreditCardInputDTO creditCardInputDTO) {
        log.info("Entered in addCreditCard() method in CreditCardServiceImpl" + creditCardInputDTO);
        if (checkInputValues(creditCardInputDTO)) {
            String creditCardNumber = creditCardInputDTO.getCardNumber();
            if (checkValidCreditCardNumber(creditCardNumber)) {
                try {
                    CreditCard creditCard = creditCardRepository.addCreditCard(getCreditCard(creditCardInputDTO));
                    if (creditCard != null) {
                        SaveResponseDTO saveResponseDTO = new SaveResponseBuilder().withCode(HttpStatus.ACCEPTED.name()).
                                withMessage("Success").build();
                        return saveResponseDTO;
                    }
                } catch (Exception e) {
                    log.info("Entered credit card number is not correct");
                }
            } else {
                throw new CreditCardNumberNotValidException(creditCardNumber);
            }
        } else {
            throw new InvalidDataInputException();
        }
        log.info("Exit from addCreditCard() method in CreditCardServiceImpl");
        return null;
    }

    @Override
    public List<CreditCardDTO> getCreditCard() {
        log.info("Entered in getCreditCard() method in CreditCardServiceImpl");
        List<CreditCard> creditCardList = creditCardRepository.getAllCreditCards();
        if (CollectionUtils.isEmpty(creditCardList)) {
            throw new DataNotFoundException();
        }
        List<CreditCardDTO> creditCardDTOList = getCreditCardDTOS(creditCardList);
        log.info("Exit from getCreditCard() method in CreditCardServiceImpl");
        return creditCardDTOList;
    }

    private List<CreditCardDTO> getCreditCardDTOS(List<CreditCard> creditCardList) {
        List<CreditCardDTO> creditCardDTOList = new ArrayList<>();
        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardList.stream().forEach(creditCard -> {
            creditCardDTO.setCardName(creditCard.getCardName());
            creditCardDTO.setCardNumber(creditCard.getCardNumber());
            creditCardDTO.setLimit(creditCard.getCardLimit());
            creditCardDTOList.add(creditCardDTO);
        });
        return creditCardDTOList;
    }

    private CreditCard getCreditCard(CreditCardInputDTO creditCardDTO) {
        return new CreditCardBuilder().withCreditCardNumber(creditCardDTO.getCardNumber()).
                withCreditCardName(creditCardDTO.getCardName()).withCreditCardLimit(creditCardDTO.getLimit()).
                build();
    }

    private boolean checkInputValues(CreditCardInputDTO creditCardInputDTO) {
        return !StringUtils.isEmpty(creditCardInputDTO.getCardNumber())
                && !StringUtils.isEmpty(creditCardInputDTO.getCardName())
                && creditCardInputDTO.getLimit() != 0L;
    }

    private boolean checkValidCreditCardNumber(String cardNumber) {
        return cardNumber.length() <= AppConstants.MAX_CARD_NUMBER_LENGTH
                && StringUtils.isNumeric(cardNumber)
                && isNumberValid(cardNumber);
    }

    private static boolean isNumberValid(String cardNumber) {
        String[] splitNumber = cardNumber.split("");
        int[] arr = Arrays.stream(splitNumber).mapToInt(Integer::parseInt).toArray();
        for (int i = arr.length - 2; i >= 0; i = i - 2) {
            int num = arr[i] * 2;
            if (num > 9) {
                num = num % 10 + num / 10;
            }
            arr[i] = num;
        }
        return sumDigits(arr) % 10 == 0;
    }

    private static int sumDigits(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
