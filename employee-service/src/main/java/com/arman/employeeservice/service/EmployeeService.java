package com.arman.employeeservice.service;

import com.arman.employeeservice.dto.ApiResponse;
import com.arman.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponse getEmployeeById(Long employeeId);
    EmployeeDto getEmployeeByEmail(String email);
}
