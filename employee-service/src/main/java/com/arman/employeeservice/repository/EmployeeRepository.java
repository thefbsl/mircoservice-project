package com.arman.employeeservice.repository;

import com.arman.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);
}
