package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CoursePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer  planid;
	
	@ManyToOne
	public Batch batch;
	
	public Integer daynumber;
	
	public String topic;
	
	
	public String status;
	
	
	
}
