package com.arman.employeeservice.service.impl;

import com.arman.employeeservice.dto.ApiResponseDto;
import com.arman.employeeservice.dto.DepartmentDto;
import com.arman.employeeservice.dto.EmployeeDto;
import com.arman.employeeservice.entity.Employee;
import com.arman.employeeservice.exception.ResourceNotFoundException;
import com.arman.employeeservice.repository.EmployeeRepository;
import com.arman.employeeservice.service.ApiClient;
import com.arman.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private ApiClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        return new ApiResponseDto(employeeDto, departmentDto);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
