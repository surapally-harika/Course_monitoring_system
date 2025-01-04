package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BatchDto;
import com.example.demo.model.Batch;
import com.example.demo.model.Faculty;

public interface BatchService {

	public Batch add(BatchDto batchdto);
	
	public List<Batch> getAll();
	
	public Batch getById(Integer batchid);
	
	public Batch update(Integer batchid,BatchDto batchdto);
	
	public Batch delete(Integer batchid);
	
	public List<Batch> getBatchByFaculty(Integer facultyid);
	
	public Batch getBatchForFaculty(Integer batchid, Faculty faculty);
	
}
