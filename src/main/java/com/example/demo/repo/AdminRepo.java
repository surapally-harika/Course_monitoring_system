package com.example.demo.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByUsername(String username);

}
