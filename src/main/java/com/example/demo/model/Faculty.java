package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer facultyid;
	
	public String facultyname;
	
	public Long mobile;
	
	public String email;
	

	
	public Faculty() {
		
	}

	public Faculty(Integer facultyid, String facultyname, Long mobile, String email) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.mobile = mobile;
		this.email = email;
		
	}

	public Integer getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(Integer facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Faculty [facultyid=" + facultyid + ", facultyname=" + facultyname + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	
	
	

	
}
