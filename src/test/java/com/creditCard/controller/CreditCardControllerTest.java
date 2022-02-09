package com.creditCard.controller;

import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.exception.InvalidDataInputException;
import com.creditCard.helper.CreditCardHelperTest;
import com.creditCard.response.SaveResponseDTO;
import com.creditCard.service.CreditCardService;
import com.security.service.UserManagementService;
import com.security.util.JwtUtil;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = CreditCardControllerTest.class)
public class CreditCardControllerTest {
    private static final String ADD_CREDITCARD_ENDPOINTS = "/creditCard/addCreditCard";
    private static final String GET_CREDITCARD_ENDPOINTS = "/creditCard/getCreditCardList";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CreditCardService creditCardService;

    @MockBean
    UserManagementService userManagementService;

    @MockBean
    JwtUtil jwtUtil;

    @Ignore
    public void addCreditCardDetails() throws Exception{
        String inputJson = "{\"cardNumber\":\"79927398713\",\"cardName\":\"Platinum Card\",\"limit\":500000}";
        String outputJson = "{\"responseCode\":\"200\",\"responseMessage\":\"Success\"}";
        SaveResponseDTO errorResponse = new SaveResponseDTO();
        errorResponse.setResponseMessage("Success");
        errorResponse.setResponseCode("200");
        Mockito.when(creditCardService.addCreditCard(Mockito.any(CreditCardInputDTO.class))).thenReturn(errorResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(ADD_CREDITCARD_ENDPOINTS)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(403, response.getStatus());
    }

    @Ignore
    public void getCreditCardTest() throws Exception {
        String outputJson = CreditCardHelperTest.getJsonString();
        List<CreditCardDTO> creditCardDTOList = CreditCardHelperTest.getCreditCardDTOList();
        Mockito.when(creditCardService.getCreditCard()).thenReturn(creditCardDTOList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(GET_CREDITCARD_ENDPOINTS)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(403,response.getStatus());
        Assertions.assertEquals(outputJson,response.getContentAsString());
    }

    @Ignore
    public void getCreditCardListTest() throws Exception {
        String outputJson = CreditCardHelperTest.getJsonString();
        List<CreditCardDTO> creditCardDTOList = CreditCardHelperTest.getCreditCardDTOList();
        //this.mockMvc.perform(get(GET_CREDITCARD_ENDPOINTS).)
        Mockito.when(creditCardService.getCreditCard()).thenThrow(new InvalidDataInputException());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(GET_CREDITCARD_ENDPOINTS)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(404,response.getStatus());
        Assertions.assertEquals(outputJson,response.getContentAsString());
    }
}
