package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Faculty;

public interface FacultyRepo  extends JpaRepository<Faculty, Integer>{

	public Faculty findByEmail(String email);

	
	
}
