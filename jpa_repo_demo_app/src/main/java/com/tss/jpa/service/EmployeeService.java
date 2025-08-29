package com.tss.jpa.service;

import java.util.List;
import java.util.Optional;

import com.tss.jpa.entity.Employee;

public interface EmployeeService {

    List<Employee> readAllEmployees();
    Employee addNewEmployee(Employee employee);
    Optional<Employee> readEmployeeById(int id);

    List<Employee> readEmployeesByName(String name);

}
