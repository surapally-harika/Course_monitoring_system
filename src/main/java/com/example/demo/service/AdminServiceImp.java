package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.repo.AdminRepo;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	public AdminRepo adminrepo;
	
	@Override
	public Admin add(AdminDto admindto) {

		Admin admin = new Admin();
		admin.setUsername(admindto.getUsername());
		admin.setPassword(admindto.getPassword());
		
		return adminrepo.save(admin);
	}

}
