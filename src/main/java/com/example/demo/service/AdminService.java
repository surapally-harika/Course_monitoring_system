package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Course;

public interface AdminService {
	
	public Admin add(AdminDto admindto);
	
	public List<Admin> AllAdmins();

}
