package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blank")
	@NotEmpty(message = "name should not ne empty")
	public String coursename;
	
	public Integer fee;
	
	public String description;
	
	
}
