package com.creditCard.service;

import com.creditCard.builder.CreditCardBuilder;
import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.entity.CreditCard;
import com.creditCard.exception.CreditCardNumberNotValidException;
import com.creditCard.exception.DataNotFoundException;
import com.creditCard.exception.InvalidDataInputException;
import com.creditCard.helper.CreditCardHelperTest;
import com.creditCard.repository.CreditCardRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardServiceImpl.class)
public class CreditCardServiceImplTest {

    @Autowired
    CreditCardServiceImpl creditCardService;

    @MockBean
    CreditCardRepositoryImpl creditCardRepository;

    @Autowired
    private MockMvc mockMvc;

    @org.junit.Test(expected = CreditCardNumberNotValidException.class)
    public void inValidCreditCardNumberTest() throws Exception {
        CreditCardInputDTO creditCardInputDTO= new CreditCardInputDTO("79927398713","CreditCard",5000);
        creditCardService.addCreditCard(creditCardInputDTO);
    }

    @org.junit.Test(expected = CreditCardNumberNotValidException.class)
    public void creditCardNumberNotNumericTest() throws Exception {
        CreditCardInputDTO creditCardInputDTO= new CreditCardInputDTO("7992swa7398713","CreditCard",5000);
        creditCardService.addCreditCard(creditCardInputDTO);
    }

    @org.junit.Test(expected = CreditCardNumberNotValidException.class)
    public void creditCardNumberLengthTest() throws Exception {
        CreditCardInputDTO creditCardInputDTO= new CreditCardInputDTO("79927398713839288292928928","CreditCard",5000);
        creditCardService.addCreditCard(creditCardInputDTO);
    }

    @Test
    public void addCreditCardNumberSuccessTest() throws Exception {
        CreditCard creditCard = new CreditCardBuilder().withCreditCardNumber("79927398713").withCreditCardName("CreditCard").withCreditCardLimit(5000).build();
        Mockito.when(creditCardRepository.addCreditCard(Mockito.any(CreditCard.class))).thenReturn(creditCard);
        CreditCard result = creditCardRepository.addCreditCard(creditCard);
        Assert.assertEquals("79927398713",result.getCradNumber());
    }

    @org.junit.Test(expected = InvalidDataInputException.class)
    public void InvalidInputCreditCardNumberTest() throws Exception {
        CreditCardInputDTO creditCardInputDTO= new CreditCardInputDTO("","",5000);
        creditCardService.addCreditCard(creditCardInputDTO);
    }

    @Test
    public void getCreditCardList() throws Exception {
        Mockito.when(creditCardRepository.getAllCreditCards()).thenReturn(CreditCardHelperTest.getCreditCardList());
        List<CreditCardDTO> creditCardDTOList = creditCardService.getCreditCard();
        Assert.assertEquals("79927398713",creditCardDTOList.get(0).getCardNumber());
    }

    @Test
    public void noRecordsFoundException() throws Exception {
        try{
            Mockito.when(creditCardRepository.getAllCreditCards()).thenThrow(DataNotFoundException.class);
            creditCardService.getCreditCard();
        }catch (Exception e){
            Assert.assertTrue(e instanceof  DataNotFoundException);
        }

    }

}
