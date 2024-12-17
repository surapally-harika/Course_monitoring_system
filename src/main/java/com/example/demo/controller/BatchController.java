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

import com.example.demo.dto.BatchDto;
import com.example.demo.model.Batch;
import com.example.demo.model.Faculty;
import com.example.demo.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	public BatchService bservice;
	
	@PostMapping("/create")
	public ResponseEntity<Batch> add(@RequestBody BatchDto batchDto){

		System.out.println(batchDto);
		
		Batch batch = bservice.add(batchDto);
		
		return new ResponseEntity<Batch>(batch,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<List<Batch>> getAll(){
		
		List<Batch> batch = bservice.getAll();
		
		return new ResponseEntity<>(batch,HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{batchid}")
	public ResponseEntity<Batch> getById(@PathVariable Integer batchid){
		
		Batch batch = bservice.getById(batchid);
		
		return new ResponseEntity<>(batch,HttpStatus.OK);
	
	}

	@PutMapping("/update/{batchid}")
	public ResponseEntity<Batch> update(@PathVariable Integer batchid,@RequestBody BatchDto batchdto){
		
		Batch batch = bservice.update(batchid,batchdto);
		
		return new ResponseEntity<>(batch,HttpStatus.OK);
	
	}
}
