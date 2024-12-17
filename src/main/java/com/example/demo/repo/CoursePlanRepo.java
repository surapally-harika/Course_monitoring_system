package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Batch;
import com.example.demo.model.CoursePlan;

public interface CoursePlanRepo extends JpaRepository<CoursePlan, Integer>{

	public List<CoursePlan> findByBatch(Batch batch);
}
