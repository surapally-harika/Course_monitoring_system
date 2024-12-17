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
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import jakarta.websocket.server.PathParam;

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
	
	
	@GetMapping("/view/{courseid}")
	public ResponseEntity<Course> getById(@PathVariable Integer courseid){
		
		Course courses = cservice.getById(courseid);
		
		return new ResponseEntity<>(courses,HttpStatus.OK);
	
	}
	
	
	@PutMapping("/update/{courseid}")
	public ResponseEntity<Course> update(@PathVariable Integer courseid,@RequestBody CourseDto coursedto){
		
		Course courses = cservice.Update(courseid,coursedto);
		
		return new ResponseEntity<>(courses,HttpStatus.OK);
	
	}

}
