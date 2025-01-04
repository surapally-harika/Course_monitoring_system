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

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Batch;
import com.example.demo.model.Faculty;
import com.example.demo.repo.BatchRepo;
import com.example.demo.repo.FacultyRepo;
import com.example.demo.service.BatchService;
import com.example.demo.service.FacultyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class FacultyController {
	
	@Autowired
	public FacultyService fservice;
	
	@Autowired
	public BatchService bService;
	
	@Autowired
	public FacultyRepo frepo;
	
	@Autowired
	public BatchRepo brepo;
	

	@PostMapping("/faculty/register")
	public ResponseEntity<Faculty> register(@Valid @RequestBody FacultyDto facultyDto){
		
		System.out.println(facultyDto);
		
		Faculty faculty = fservice.register(facultyDto);
		return new ResponseEntity<Faculty>(faculty,HttpStatus.CREATED);
	}
	
	
	@PostMapping("faculty/login")
	public ResponseEntity<String> loginFaculty( @RequestBody FacultyDto facultyDto) {
	    try {
	      Faculty faculty = fservice.login(facultyDto.getEmail(), facultyDto.getPassword());
	        if (faculty == null) {
	            return ResponseEntity.status(401).body("Invalid username or password");
	        }
	        String message = "Login successful for user: " + faculty.getEmail();
	        return ResponseEntity.ok(message);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(401).body(e.getMessage());
	    }
	}
	
	
	@GetMapping("/faculty/view")
	public ResponseEntity<List<Faculty>> getAll(){
		
		List<Faculty> faculty = fservice.AllFaculty();
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	}
	
	
	@GetMapping("faculty/view/{facultyid}")
	public ResponseEntity<Faculty> getById(@PathVariable Integer facultyid){
		
		Faculty faculty = fservice.getById(facultyid);
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	
	}
	
	@PutMapping("faculty/update/{facultyid}")
	public ResponseEntity<Faculty> update(@Valid @PathVariable Integer facultyid,@RequestBody FacultyDto facultyDto){
		
		Faculty faculty = fservice.update(facultyid,facultyDto);
		
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	
	}
	
	@GetMapping("/{facultyid}/batch")
    public ResponseEntity<List<Batch>> getBatchesByFaculty(@PathVariable Integer facultyid) {
		
        List<Batch> batches = bService.getBatchByFaculty(facultyid);
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }
	
	
	

}
