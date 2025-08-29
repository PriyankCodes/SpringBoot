package com.tss.jpa.service;

import com.tss.jpa.dto.EmployeeRequestDto;
import com.tss.jpa.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> readAllEmployees();
    EmployeeResponseDto addNewEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto readEmployeeById(int id);
    List<EmployeeResponseDto> readEmployeesByName(String name);
}
