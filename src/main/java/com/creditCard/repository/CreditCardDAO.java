package com.creditCard.repository;

import com.creditCard.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDAO extends JpaRepository<CreditCard, Long> {
}
