package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.POST})
public class AdminController {
	
	@Autowired
	public AdminService aservice;
	
	@PostMapping("/admin/register")
	public ResponseEntity<Admin> add(@Valid @RequestBody AdminDto adminDto){
		
		System.out.println(adminDto);
		
		Admin admin = aservice.register(adminDto);
		return new ResponseEntity<Admin>(admin,HttpStatus.CREATED);
		
	}
	


	@PostMapping("admin/login")
	public ResponseEntity<String> loginAdmin( @RequestBody AdminDto adminDto) {
	    try {
	       Admin admin = aservice.loginAdmin(adminDto.getUsername(), adminDto.getPassword());
	        if (admin == null) {
	            return ResponseEntity.status(401).body("Invalid username or password");
	        }
	        String message = "Login successful for user: " + admin.getUsername();
	        return ResponseEntity.ok(message);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(401).body(e.getMessage());
	    }
	}
	


}
