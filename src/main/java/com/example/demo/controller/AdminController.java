package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;


@RestController
@RequestMapping("/course")
public class AdminController {
	
	@Autowired
	public AdminService aservice;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> add(@RequestBody AdminDto adminDto){
		
		System.out.println(adminDto);
		
		Admin admin = aservice.add(adminDto);
		return new ResponseEntity<Admin>(admin,HttpStatus.CREATED);
		
	}

}
