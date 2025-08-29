package com.tss.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tss.hibernate.entity.Employee;
import com.tss.hibernate.service.EmployeeService;

@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.getEmployeesByName(name);
    }

    @GetMapping("/employees/salary/{salary}")
    public List<Employee> getEmployeesBySalary(@PathVariable double salary) {
        return employeeService.getEmployeesBySalary(salary);
    }

    @GetMapping("/employees/dept/{deptName}")
    public List<Employee> getEmployeesByDept(@PathVariable String deptName) {
        return employeeService.getEmployeesByDept(deptName);
    }
}
