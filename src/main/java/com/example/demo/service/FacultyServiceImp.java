package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.exceptions.CourseException;
import com.example.demo.model.Faculty;
import com.example.demo.repo.FacultyRepo;

@Service
public class FacultyServiceImp implements FacultyService{

	@Autowired
	public FacultyRepo facultyrepo;
	
//	@Autowired
//	public BatchRepo batchRepo;
	
	@Override
	public Faculty register(FacultyDto facultydto) {
		
		Faculty faculty = new Faculty();
		faculty.setFacultyname(facultydto.getFacultyname());
		faculty.setEmail(facultydto.getEmail());
		faculty.setMobile(facultydto.getMobile());
		faculty.setPassword(facultydto.getPassword());
		
		
		return facultyrepo.save(faculty);
	}

	@Override
	public List<Faculty> AllFaculty() {
		
		return facultyrepo.findAll();
	}

	@Override
	public Faculty getById(Integer facultyid) {
		
		return facultyrepo.findById(facultyid).orElseThrow( () -> new CourseException("There is no faculty with this id") );
	}

	
	@Override
	public Faculty update(Integer facultyid, FacultyDto facultydto) {
		
		Faculty faculty = facultyrepo.findById(facultyid)
	            .orElseThrow(() -> new CourseException("Faculty not found with ID: " + facultyid));

		
		if(facultydto.getEmail() != null) {
		faculty.setEmail(facultydto.getEmail());
		}
		if(facultydto.getMobile() != null) {
		faculty.setMobile(facultydto.getMobile());
		}
		return facultyrepo.save(faculty);	

	}



	@Override
	public Faculty login(String email, String password) {
		
		Faculty faculty = facultyrepo.findByEmail(email);
        if (faculty == null) {
            throw new CourseException("Invalid email or password");
        }

     
        if (!password.matches(password)) {
            throw new CourseException("Invalid email or password");
        }

        return faculty; 	
        }



	
	
}
