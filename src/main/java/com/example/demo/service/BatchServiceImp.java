package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchDto;
import com.example.demo.exceptions.CourseException;
import com.example.demo.model.Batch;
import com.example.demo.model.Course;
import com.example.demo.model.Faculty;
import com.example.demo.repo.BatchRepo;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.FacultyRepo;

@Service
public class BatchServiceImp implements BatchService {

	@Autowired
	public BatchRepo batchrepo;
	
	@Autowired
	public CourseRepo cRepo;
	
	@Autowired
	public FacultyRepo fRepo;
	
	@Override
	public Batch add(BatchDto batchdto) {
		
		Batch batch = new Batch();

		batch.setDate(batchdto.getDate());
		batch.setDuration(batchdto.getDuration());
		batch.setNoOfstudents(batchdto.getNoOfstudents());
		
		//get particular course
		    
		    Course c =   cRepo.findById(batchdto.getCourseId()).orElseThrow(() -> new CourseException("There in no course with this id "+ batchdto.getCourseId()));
		
		    Faculty f = fRepo.findById(batchdto.getFacultyId()).orElseThrow(() -> new CourseException("There is not faculty with this id "+ batchdto.getFacultyId()));
	
		  
		    batch.setFaculty(f);
		    batch.setCourse(c);
		    
		    
		    return batchrepo.save(batch);
	}

	@Override
	public List<Batch> getAll() {
		
		return batchrepo.findAll();
	}

	@Override
	public Batch getById(Integer batchid) {
		
		return batchrepo.findById(batchid).orElseThrow( () -> new CourseException("There is no batch with this id") );
	}

	
	
	@Override
	public Batch update(Integer batchid, BatchDto batchdto) {

		Batch batch = getById(batchid);
		
		if(batchdto.getDate() != null) {
			batch.setDate(batchdto.getDate());
		}
		
		if(batchdto.getDuration() != null) {
			batch.setDuration(batchdto.getDuration());
		}
		
		if(batchdto.getNoOfstudents() != null) {
			batch.setNoOfstudents(batchdto.getNoOfstudents());
		}
		if(batchdto.getFacultyId() != null) {
			Faculty f = fRepo.findById(batchdto.getFacultyId()).orElseThrow(() -> new CourseException("There is not faculty with this id "+ batchdto.getFacultyId()));
			batch.setFaculty(f);
		}
		if(batchdto.getCourseId() != null) {
			Course c =   cRepo.findById(batchdto.getCourseId()).orElseThrow(() -> new CourseException("There in no course with this id "+ batchdto.getCourseId()));
			batch.setCourse(c);
		}
		return batchrepo.save(batch);	
	}

}
