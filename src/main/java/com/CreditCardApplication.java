package com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardApplication.class, args);
		System.out.println("Spring boot application started for Bank Credit Card Rest API");
    }

}
