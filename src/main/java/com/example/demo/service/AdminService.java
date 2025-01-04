package com.example.demo.service;



import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;

public interface AdminService {
	
	public Admin register(AdminDto admindto);
	
	public Admin loginAdmin(String username, String password);
	
//	public Admin loginAdminService(AdminLoginDto loginDto);
	
//	public List<Admin> AllAdmins();

}
