package com.example.demo.dto;

public class CourseDto {

public String coursename;
	
	public Integer fee;
	
	public String description;
	
	
	public CourseDto() {
		
	}


	public CourseDto(String coursename, Integer fee, String description) {
		super();
		this.coursename = coursename;
		this.fee = fee;
		this.description = description;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	public Integer getFee() {
		return fee;
	}


	public void setFee(Integer fee) {
		this.fee = fee;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "CourseDto [coursename=" + coursename + ", fee=" + fee + ", description=" + description + "]";
	}
	
	
}
