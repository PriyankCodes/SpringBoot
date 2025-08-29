package com.tss.jpa.service;

import com.tss.jpa.dto.EmployeeRequestDto;
import com.tss.jpa.dto.EmployeeResponseDto;
import com.tss.jpa.entity.Employee;
import com.tss.jpa.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeResponseDto> readAllEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto addNewEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        Employee saved = employeeRepo.save(employee);
        return modelMapper.map(saved, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto readEmployeeById(int id) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return modelMapper.map(emp, EmployeeResponseDto.class);
    }

    @Override
    public List<EmployeeResponseDto> readEmployeesByName(String name) {
        return employeeRepo.findByName(name)
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }
}
