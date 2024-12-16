package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer batchid;
	
	@ManyToOne
	public Course course;
	
	@ManyToOne
	public Faculty faculty;
	
	public Integer noOfstudents;
	
	public String date;
	
	public String duration;
	
	public Batch() {
		
	}

	public Batch(Integer batchid, Course course, Faculty faculty, Integer noOfstudents, String date, String duration) {
		super();
		this.batchid = batchid;
		this.course = course;
		this.faculty = faculty;
		this.noOfstudents = noOfstudents;
		this.date = date;
		this.duration = duration;
	}

	public Integer getBatchid() {
		return batchid;
	}

	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
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
		return "Batch [batchid=" + batchid + ", course=" + course + ", faculty=" + faculty + ", noOfstudents="
				+ noOfstudents + ", date=" + date + ", duration=" + duration + "]";
	}
	
	
	
}
