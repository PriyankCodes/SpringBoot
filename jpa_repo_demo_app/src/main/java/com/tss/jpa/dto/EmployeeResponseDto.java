package com.tss.jpa.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDto {
    private int id;
    private String deptname;
    private String name;
    private double salary;
}
