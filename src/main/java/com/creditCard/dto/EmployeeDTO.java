package com.creditCard.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class EmployeeDTO {
    private String empId;
    private String ename;
    private String email;
    private long salary;
    private DepartmentDTO department;
}
