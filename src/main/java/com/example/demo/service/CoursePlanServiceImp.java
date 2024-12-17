package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CoursePlanDto;
import com.example.demo.exceptions.CourseException;
import com.example.demo.model.Batch;
import com.example.demo.model.Course;
import com.example.demo.model.CoursePlan;
import com.example.demo.model.Faculty;
import com.example.demo.repo.BatchRepo;
import com.example.demo.repo.CoursePlanRepo;

@Service
public class CoursePlanServiceImp implements CoursePlanService{
	
	@Autowired
	public CoursePlanRepo cprepo;
	
	@Autowired
	public BatchRepo brepo;

	@Override
	public CoursePlan create(CoursePlanDto courseplanDto) {

		CoursePlan cp = new CoursePlan();

		cp.setDaynumber(courseplanDto.getDaynumber());
		cp.setStatus(courseplanDto.getStatus());
		cp.setTopic(courseplanDto.getTopic());
		
		
	    Batch b = brepo.findById(courseplanDto.getBatchid()).orElseThrow(() -> new CourseException("There is not batch with this id "+ courseplanDto.getBatchid()));

	    cp.setBatch(b);
	    
	    
	    return cprepo.save(cp);

	}

	
	
	@Override
	public List<CoursePlan> AllCourseplan() {
		
		return cprepo.findAll();
	}

	
	
	@Override
	public CoursePlan getById(Integer batchid) {
		// TODO Auto-generated method stub
		return cprepo.findById(batchid).orElseThrow( () -> new CourseException("There is no courseplan with this id") );
	}



	@Override
	public CoursePlan update(Integer planid, CoursePlanDto coursePlanDto) {
		
		CoursePlan cp = new CoursePlan();
		
		if(cp.getBatch() != null) {
			 Batch b = brepo.findById(coursePlanDto.getBatchid()).orElseThrow(() -> new CourseException("There is not batch with this id "+ coursePlanDto.getBatchid()));
			    cp.setBatch(b);
		}
		if(cp.getDaynumber() != null) {
			cp.setDaynumber(coursePlanDto.getDaynumber());
		}
		if(cp.getStatus() != null) {
			cp.setStatus(coursePlanDto.getStatus());
		}
		if(cp.getTopic() != null) {
			cp.setTopic(coursePlanDto.getTopic());
		}
		return cprepo.save(cp);
	}
}
