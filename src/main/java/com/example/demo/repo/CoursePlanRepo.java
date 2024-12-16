package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CoursePlan;

public interface CoursePlanRepo extends JpaRepository<CoursePlan, Integer>{

}
