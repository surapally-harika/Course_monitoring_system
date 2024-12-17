package com.example.demo.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ErrorMessage {

	
	public LocalDateTime timestamp;
	 
	 
	 public String message;
	 
	 
	 public Integer status;
	 
	 
	 
	 public String  path;
	 
	 public ErrorMessage() {
		 
	 }

	public ErrorMessage(LocalDateTime timestamp, String message, Integer status, String path) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.path = path;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	 
	 
}
