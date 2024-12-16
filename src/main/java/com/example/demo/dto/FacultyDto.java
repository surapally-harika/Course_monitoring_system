package com.example.demo.dto;

public class FacultyDto {

public String facultyname;
	
	public Long mobile;
	
	public String email;
	
	public String username;
	
	public String password;
	

	
	public FacultyDto() {
		
	}



	public FacultyDto(String facultyname, Long mobile, String email, String username, String password) {
		super();
		this.facultyname = facultyname;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
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



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "FacultyDto [facultyname=" + facultyname + ", mobile=" + mobile + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
