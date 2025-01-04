package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
	
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	@NotBlank(message = "name should not be blank")
	public String facultyname;
	
	@Min(10)
	public Long mobile;
	
	@NotNull(message = "email should not be null")
	@NotEmpty(message = "email should not be empty")
	@NotBlank(message = "email should not be blank")
	public String email;
	
	
	public String password;
	

}
