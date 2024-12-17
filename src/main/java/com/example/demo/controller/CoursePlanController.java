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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.CoursePlanDto;
import com.example.demo.model.Course;
import com.example.demo.model.CoursePlan;
import com.example.demo.service.CoursePlanService;

@RestController
@RequestMapping("/courseplan")
public class CoursePlanController {

	@Autowired
	public CoursePlanService cpService;
	
	@PostMapping("/create")
	public ResponseEntity<CoursePlan> add(@RequestBody CoursePlanDto courseDPlanDto){
		
		System.out.println(courseDPlanDto);
		
		CoursePlan courseplan = cpService.create(courseDPlanDto);
		return new ResponseEntity<CoursePlan>(courseplan,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<List<CoursePlan>> AllCourses(){
		
		List<CoursePlan> courseplan = cpService.AllCourseplan();
		
		return new ResponseEntity<>(courseplan,HttpStatus.OK);
	
	}
	
	
	@GetMapping("/view/{planid}")
	public ResponseEntity<CoursePlan> getById(@PathVariable Integer planid){
		
		CoursePlan courseplan = cpService.getById(planid);
		
		return new ResponseEntity<>(courseplan,HttpStatus.OK);
	
	}
	
	@PutMapping("/update/{batchid}")
	public ResponseEntity<CoursePlan> update(@PathVariable Integer batchid,@RequestBody CoursePlanDto coursePlanDto){
		
		CoursePlan courseplan = cpService.update(batchid,coursePlanDto);
		
		return new ResponseEntity<>(courseplan,HttpStatus.OK);
	
	}
}
