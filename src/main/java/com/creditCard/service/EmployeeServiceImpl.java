package com.creditCard.service;

import com.creditCard.builder.CreditCardBuilder;
import com.creditCard.builder.SaveResponseBuilder;
import com.creditCard.config.AppConstants;
import com.creditCard.dto.CreditCardDTO;
import com.creditCard.dto.CreditCardInputDTO;
import com.creditCard.dto.DepartmentDTO;
import com.creditCard.dto.EmployeeDTO;
import com.creditCard.entity.CreditCard;
import com.creditCard.entity.Department;
import com.creditCard.entity.Employee;
import com.creditCard.exception.CreditCardNumberNotValidException;
import com.creditCard.exception.DataNotFoundException;
import com.creditCard.exception.InvalidDataInputException;
import com.creditCard.repository.CreditCardRepository;
import com.creditCard.repository.DepartmentRepository;
import com.creditCard.repository.EmployeeRepository;
import com.creditCard.response.SaveResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    /**
     * @param employeeDTO
     */
    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee emp = new Employee();
        Department dept = new Department();
        emp.setEmployeeName(employeeDTO.getEname());
        emp.setEmail(employeeDTO.getEmail());
        emp.setSalary(employeeDTO.getSalary());
        //emp.setEmployeeId(emp.getEmployeeId());

        //dept.setDepartmentId(employeeDTO.getDepartment().getDepartmentId());
        dept.setDepartmentName(employeeDTO.getDepartment().getDepartmentName());
        Department deptResults = departmentRepository.save(dept);
        emp.setDepartment(deptResults);
        Employee employee = employeeRepository.save(emp);
        EmployeeDTO employeeDTO1 = matToDTO(deptResults, employee);
        return employeeDTO1;
    }

    private EmployeeDTO matToDTO(Department deptResults, Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        employeeDTO.setEmpId(String.valueOf(employee.getEmployeeId()));
        employeeDTO.setEname(employee.getEmployeeName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setSalary(employee.getSalary());
        departmentDTO.setDepartmentId(deptResults.getDepartmentId());
        departmentDTO.setDepartmentName(deptResults.getDepartmentName());
        employeeDTO.setDepartment(departmentDTO);
        return employeeDTO;
    }
}
