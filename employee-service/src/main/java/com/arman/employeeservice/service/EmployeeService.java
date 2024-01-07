package com.arman.employeeservice.service;

import com.arman.employeeservice.dto.ApiResponseDto;
import com.arman.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long employeeId);
    EmployeeDto getEmployeeByEmail(String email);
}
