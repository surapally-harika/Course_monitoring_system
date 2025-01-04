package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.exceptions.CourseException;
import com.example.demo.model.Admin;
import com.example.demo.repo.AdminRepo;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	public AdminRepo adminrepo;

	
	@Override
	public Admin register(AdminDto admindto) {

		Admin admin = new Admin();
		admin.setUsername(admindto.getUsername());
		admin.setPassword(admindto.getPassword());
		
		return adminrepo.save(admin);
	}


	@Override
	public Admin loginAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = adminrepo.findByUsername(username);
        if (admin == null) {
            throw new CourseException("Invalid username or password");
        }

     
        if (!password.matches(password)) {
            throw new CourseException("Invalid username or password");
        }

        return admin; 
    }

	

}
