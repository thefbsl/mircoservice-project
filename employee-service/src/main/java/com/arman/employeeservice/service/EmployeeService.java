package com.arman.employeeservice.service;

import com.arman.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    EmployeeDto getEmployeeByEmail(String email);
}
