package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepo;

@Service
public class CourseServiceImp implements CourseService{
	
	@Autowired
	public CourseRepo courserepo;

	@Override
	public Course create(CourseDto courseDto) {
		Course course = new Course();
		course.setCoursename(courseDto.getCoursename());
		course.setFee(courseDto.getFee());
		course.setDescription(courseDto.getDescription());
		return courserepo.save(course);
	}

	@Override
	public List<Course> AllCourses() {
		
		return courserepo.findAll();
	}

}
