package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.CoursePlanDto;
import com.example.demo.model.CoursePlan;
import com.example.demo.service.CoursePlanService;

@RestController
@RequestMapping("/api/courseplan")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

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
	
	
	@GetMapping("/view/{batchid}")
	public ResponseEntity<List<CoursePlan>> getById(@PathVariable Integer batchid){
		
		List<CoursePlan> courseplan = cpService.getById(batchid);
		
		return new ResponseEntity<>(courseplan,HttpStatus.OK);
	
	}
	
	@PutMapping("/update/{batchid}")
	public ResponseEntity<CoursePlan> update(@PathVariable Integer batchid,@RequestBody CoursePlanDto coursePlanDto){
		
//		System.out.println(batchid + " " + coursePlanDto);
		CoursePlan courseplan = cpService.update(batchid,coursePlanDto);
		
		return new ResponseEntity<>(courseplan,HttpStatus.OK);
	
	}
}
