package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Faculty;
import com.example.demo.repo.FacultyRepo;

@Service
public class FacultyServiceImp implements FacultyService{

	@Autowired
	public FacultyRepo facultyrepo;
	
	@Override
	public Faculty create(FacultyDto facultydto) {
		
		Faculty faculty = new Faculty();
		faculty.setFacultyname(facultydto.getFacultyname());
		faculty.setEmail(facultydto.getEmail());
		faculty.setMobile(facultydto.getMobile());
		
		
		return facultyrepo.save(faculty);
	}

	@Override
	public List<Faculty> AllFaculty() {
		
		return facultyrepo.findAll();
	}

}
