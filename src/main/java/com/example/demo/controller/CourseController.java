package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	

	@Autowired
	public CourseService cservice;
	
	@PostMapping("/create")
	public ResponseEntity<Course> add(@RequestBody CourseDto courseDto){
		
		System.out.println(courseDto);
		
		Course course = cservice.create(courseDto);
		return new ResponseEntity<Course>(course,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<List<Course>> AllCourses(){
		
		List<Course> courses = cservice.AllCourses();
		
		return new ResponseEntity<>(courses,HttpStatus.OK);
	
	}

}
