package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	public List<CoursePlan> getById(Integer batchid) {
		
		Optional<Batch> batchop = brepo.findById(batchid);
		Batch batch = batchop.orElseThrow(() -> new CourseException("batch not found:"+batchid));
		
		List<CoursePlan> courseplan = cprepo.findByBatch(batch);
	
		if (courseplan.isEmpty()) {
            throw new CourseException("No course plans found for batch ID: " + batchid);
        }
        
        return courseplan;
	}


	@Override
	public CoursePlan update(Integer planid, CoursePlanDto coursePlanDto) {
		
		 CoursePlan cp = cprepo.findById(planid)
		            .orElseThrow(() -> new CourseException("Course plan not found with ID: " + planid));

		    // Update fields only if provided
		    if (coursePlanDto.getDaynumber() != null) {
		        cp.setDaynumber(coursePlanDto.getDaynumber());
		    }
		    if (coursePlanDto.getStatus() != null) {
		        cp.setStatus(coursePlanDto.getStatus());
		    }
		    if (coursePlanDto.getTopic() != null) {
		        cp.setTopic(coursePlanDto.getTopic());
		    }

		    return cprepo.save(cp);
	}
}
