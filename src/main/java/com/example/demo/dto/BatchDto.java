package com.example.demo.dto;

import com.example.demo.model.Course;
import com.example.demo.model.Faculty;

import jakarta.persistence.ManyToOne;

public class BatchDto {

	@ManyToOne
	public Course course;
	
	@ManyToOne
	public Faculty faculty;
	
	public Integer noOfstudents;
	
	public String date;
	
	public String duration;
	
	
	public BatchDto() {
		
	}


	public BatchDto(Course course, Faculty faculty, Integer noOfstudents, String date, String duration) {
		super();
		this.course = course;
		this.faculty = faculty;
		this.noOfstudents = noOfstudents;
		this.date = date;
		this.duration = duration;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public Integer getNoOfstudents() {
		return noOfstudents;
	}


	public void setNoOfstudents(Integer noOfstudents) {
		this.noOfstudents = noOfstudents;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "BatchDto [course=" + course + ", faculty=" + faculty + ", noOfstudents=" + noOfstudents + ", date="
				+ date + ", duration=" + duration + "]";
	}
	
	
}
