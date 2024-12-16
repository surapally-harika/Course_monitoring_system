package com.example.demo.dto;

import com.example.demo.model.Batch;

import jakarta.persistence.ManyToOne;

public class CoursePlanDto {

	@ManyToOne
	public Batch batch;
	
	public Integer daynumber;
	
	public String topic;
	
	
	public String status;
	
	public CoursePlanDto() {
		
		
	}

	public CoursePlanDto(Batch batch, Integer daynumber, String topic, String status) {
		super();
		this.batch = batch;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Integer getDaynumber() {
		return daynumber;
	}

	public void setDaynumber(Integer daynumber) {
		this.daynumber = daynumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CoursePlanDto [batch=" + batch + ", daynumber=" + daynumber + ", topic=" + topic + ", status=" + status
				+ "]";
	}
	
	
}
