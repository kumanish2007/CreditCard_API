package com.creditCard.repository;

import com.creditCard.entity.CreditCard;
import com.creditCard.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
