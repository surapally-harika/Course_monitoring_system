package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.exceptions.CourseException;
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

	@Override
	public Course getById(Integer courseid) {
		
	  return courserepo.findById(courseid).orElseThrow( () -> new CourseException("There is no course with this id") );
		

	}

	@Override
	public Course Update(Integer courseid, CourseDto coursedto) {
		
		Course course = getById(courseid);
		
		if(coursedto.getFee() != null) {
			course.setFee(coursedto.getFee());
		}
		return courserepo.save(course);
	}


}
