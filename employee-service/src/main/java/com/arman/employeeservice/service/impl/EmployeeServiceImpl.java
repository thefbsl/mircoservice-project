package com.arman.employeeservice.service.impl;

import com.arman.employeeservice.dto.ApiResponse;
import com.arman.employeeservice.dto.DepartmentDto;
import com.arman.employeeservice.dto.EmployeeDto;
import com.arman.employeeservice.entity.Employee;
import com.arman.employeeservice.exception.ResourceNotFoundException;
import com.arman.employeeservice.repository.EmployeeRepository;
import com.arman.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public ApiResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        String url = "http://localhost:8080/api/departments/" + employee.getDepartmentCode();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(url, DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return new ApiResponse(employeeDto, departmentDto);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
