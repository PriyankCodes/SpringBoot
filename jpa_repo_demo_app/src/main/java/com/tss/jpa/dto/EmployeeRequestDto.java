package com.tss.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDto {

    @NotBlank(message = "Department name cannot be blank")
    private String deptname;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Salary is required")
    @Min(value = 1000, message = "Salary must be at least 1000")
    private Double salary;
}
