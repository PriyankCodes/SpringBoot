package com.tss.jpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class StudentRequestDto {

	  @NotBlank(message = "First name cannot be blank")
	    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "First name must be 2-30 letters only")
	    private String firstName;

	    @NotBlank(message = "Last name cannot be blank")
	    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Last name must be 2-30 letters only")
	    private String lastName;

	    @Min(value = 1, message = "Roll number must be greater than 0")
	    @Max(value = 9999, message = "Roll number must be less than or equal to 9999")
	    private int rollNumber;

	    @NotBlank(message = "Email cannot be blank")
	    @Email(message = "Invalid email format")
	    private String email;

	    @Min(value = 5, message = "Age must be at least 5")
	    @Max(value = 100, message = "Age must be less than or equal to 100")
	    private int age;

}
