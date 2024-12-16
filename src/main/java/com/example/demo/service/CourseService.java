package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;

public interface CourseService {
	
	public Course create(CourseDto courseDto);
	
	public List<Course> AllCourses();

}
