package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Batch;

public interface BatchRepo extends JpaRepository<Batch, Integer>{

}
