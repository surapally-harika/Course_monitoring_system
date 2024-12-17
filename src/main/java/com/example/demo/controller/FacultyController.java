package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Course;
import com.example.demo.model.Faculty;
import com.example.demo.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	public FacultyService fservice;

	@PostMapping("/create")
	public ResponseEntity<Faculty> add(@RequestBody FacultyDto facultyDto){
		
		System.out.println(facultyDto);
		
		Faculty faculty = fservice.create(facultyDto);
		return new ResponseEntity<Faculty>(faculty,HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<Faculty>> getAll(){
		
		List<Faculty> faculty = fservice.AllFaculty();
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{facultyid}")
	public ResponseEntity<Faculty> getById(@PathVariable Integer facultyid){
		
		Faculty faculty = fservice.getById(facultyid);
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	
	}
	
	@PutMapping("/update/{facultyid}")
	public ResponseEntity<Faculty> update(@PathVariable Integer facultyid,@RequestBody FacultyDto facultyDto){
		
		Faculty faculty = fservice.update(facultyid,facultyDto);
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	
	}
	
	
}
