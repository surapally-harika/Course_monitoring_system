package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Batch;
import com.example.demo.model.Faculty;

public interface BatchRepo extends JpaRepository<Batch, Integer>{

	List<Batch> findByFaculty(Faculty faculty);
	
	Batch findByBatchidAndFaculty(Integer batchid, Faculty faculty);
}
