package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BatchDto;
import com.example.demo.model.Batch;

public interface BatchService {

	public Batch add(BatchDto batchdto);
	
	public List<Batch> getAll();
	
	public Batch getById(Integer batchid);
	
	public Batch update(Integer batchid,BatchDto batchdto);
	
	
}
