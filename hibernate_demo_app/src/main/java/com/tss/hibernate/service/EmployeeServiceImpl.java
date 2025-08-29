package com.tss.hibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.hibernate.dao.EmployeeDao;
import com.tss.hibernate.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addNewEmployee(Employee employee) {
        return employeeDao.addNewEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeDao.getEmployeesByName(name);
    }

    @Override
    public List<Employee> getEmployeesBySalary(double salary) {
        return employeeDao.getEmployeesBySalary(salary);
    }

    @Override
    public List<Employee> getEmployeesByDept(String deptName) {
        return employeeDao.getEmployeesByDept(deptName);
    }
}
