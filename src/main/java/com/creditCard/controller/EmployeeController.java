package com.creditCard.controller;

import com.creditCard.dto.EmployeeDTO;
import com.creditCard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

@Autowired
EmployeeService employeeService;

@PostMapping("/saveEmployee")
public String addEmployee(@RequestBody EmployeeDTO employeeDTO){
    employeeService.addEmployee(employeeDTO);
    return "Records inserted successfully !";
}
}
