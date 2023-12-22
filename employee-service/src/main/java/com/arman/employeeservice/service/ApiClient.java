package com.arman.employeeservice.service;

import com.arman.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);
}
