package com.creditCard.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    @Column(name="CARD_NUMBER",unique = true)
    private String cardNumber;
    @Column(name="CARD_NAME",unique = false)
    private String cardName;
    @Column(name="CARD_LIMIT",unique = false)
    private long cardLimit;
    @Column(name="CARD_BALANCE")
    private long balance;
}
