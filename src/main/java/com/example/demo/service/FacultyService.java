package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Course;
import com.example.demo.model.Faculty;

public interface FacultyService {
	
	public Faculty create(FacultyDto facultydto);
	
	public List<Faculty> AllFaculty();
	
	public Faculty getById(Integer facultyid);
	
	public Faculty update(Integer facultyid,FacultyDto facultydto);

}
