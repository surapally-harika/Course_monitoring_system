package com.example.demo.service;

import com.example.demo.dto.BatchDto;
import com.example.demo.dto.CourseDto;
import com.example.demo.model.Batch;
import com.example.demo.model.Course;

public class BatchServiceImp implements BatchService {

	@Override
	public Batch create(BatchDto batchdto) {
		Batch batch = new Batch();
		batch.setDate(batchdto.getDate());
		batch.setDuration(batchdto.getDuration());
		batch.setNoOfstudents(batch.getNoOfstudents());
		batch.setCourse(batchdto.getCourse());
//		batch.setFaculty();
		return null;
	}

}
