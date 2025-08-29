package com.tss.hibernate.service;

import java.util.List;
import com.tss.hibernate.entity.Employee;

public interface EmployeeService {

    Employee addNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesBySalary(double salary);

    List<Employee> getEmployeesByDept(String deptName);
}
