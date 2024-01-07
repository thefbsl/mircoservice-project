package com.arman.employeeservice.controller;

import com.arman.employeeservice.dto.ApiResponseDto;
import com.arman.employeeservice.dto.EmployeeDto;
import com.arman.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(apiResponseDto);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String email){
        EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
