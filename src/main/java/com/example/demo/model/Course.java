package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer couseid;
	
	public String coursename;
	
	public Integer fee;
	
	public String description;
	
	public Course() {
		
	}

	public Course(Integer couseid, String coursename, Integer fee, String description) {
		super();
		this.couseid = couseid;
		this.coursename = coursename;
		this.fee = fee;
		this.description = description;
	}

	public Integer getCouseid() {
		return couseid;
	}

	public void setCouseid(Integer couseid) {
		this.couseid = couseid;
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
		return "Course [couseid=" + couseid + ", coursename=" + coursename + ", fee=" + fee + ", description="
				+ description + "]";
	}
	
	

}
