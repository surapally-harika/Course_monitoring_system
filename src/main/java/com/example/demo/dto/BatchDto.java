package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {

	
	public Integer courseId;
	
	
	public Integer facultyId;
	
	public Integer noOfstudents;
	
	public String date;
	
	public String duration;
	

	
}
