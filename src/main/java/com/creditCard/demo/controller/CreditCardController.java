package com.creditCard.demo.controller;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@XSlf4j
@RequestMapping("/creditCard")
public class CreditCardController {

@GetMapping("/getList")
public String getList(){
    List list = new ArrayList<String>();
    list.add("abc");
    list.add("kbc");
    list.add("ppc");
    return "hello";
}
}
