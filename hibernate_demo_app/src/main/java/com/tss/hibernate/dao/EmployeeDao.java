package com.tss.hibernate.dao;

import java.util.List;
import com.tss.hibernate.entity.Employee;

public interface EmployeeDao {

    Employee addNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesBySalary(double salary);

    List<Employee> getEmployeesByDept(String deptName);
}
