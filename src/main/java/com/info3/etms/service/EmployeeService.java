package com.info3.etms.service;

import com.info3.etms.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Long id);
}
