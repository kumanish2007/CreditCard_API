package com.creditCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardApplication.class, args);
		System.out.println("Spring boot application started for Rest API");
    }

}
