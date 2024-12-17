package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CoursePlanDto;
import com.example.demo.model.CoursePlan;

public interface CoursePlanService {
	
	public CoursePlan create(CoursePlanDto courseplanDto);
	
	public List<CoursePlan> AllCourseplan();
	
	public List<CoursePlan> getById(Integer batchid);

	public CoursePlan update(Integer planid,CoursePlanDto coursePlanDto);
}
