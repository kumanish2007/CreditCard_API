package com.creditCard.helper;

import com.creditCard.builder.CreditCardBuilder;
import com.creditCard.builder.CreditCardDTOBuilder;
import com.creditCard.dto.CreditCardDTO;
import com.creditCard.entity.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardHelperTest {

    public static String getJsonString(){
        String jsonString = "[{\n" +
                "        \"cardName\": \"CreditCard\",\n" +
                "        \"cardNumber\": \"79927398713\",\n" +
                "        \"limit\": 5000,\n" +
                "        \"balance\": 0\n" +
                "    },{\n" +
                "        \"cardName\": \"CreditCard\",\n" +
                "        \"cardNumber\": \"12345674\",\n" +
                "        \"limit\": 15000,\n" +
                "        \"balance\": 0\n" +
                "    }]";
        return jsonString;
    }

    public static List<CreditCardDTO> getCreditCardDTOList(){
        List<CreditCardDTO> creditCardDTOs = new ArrayList<>();
        creditCardDTOs.add(new CreditCardDTOBuilder().withCreditCardNumber("12345674")
                .withCreditCardName("CreditCard").withCreditCardLimit(15000l).withCreditBalance(0l).build());
        creditCardDTOs.add(new CreditCardDTOBuilder().withCreditCardNumber("79927398713")
                .withCreditCardName("CreditCard").withCreditCardLimit(5000l).withCreditBalance(0l).build());
     return creditCardDTOs;
    }

    public static List<CreditCard> getCreditCardList(){
        List<CreditCard> creditCard = new ArrayList<>();
        creditCard.add(new CreditCardBuilder().withCreditCardNumber("12345674")
                .withCreditCardName("CreditCard").withCreditCardLimit(15000l).withCreditBalance(0l).build());
        creditCard.add(new CreditCardBuilder().withCreditCardNumber("79927398713")
                .withCreditCardName("CreditCard").withCreditCardLimit(5000l).withCreditBalance(0l).build());
        return creditCard;
    }

}
