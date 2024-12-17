package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomeException {

	
	@ExceptionHandler(exception = CourseException.class)
	public ResponseEntity<ErrorMessage> productException(CourseException pe, HttpServletRequest req) {
		
		   ErrorMessage erm = new ErrorMessage(LocalDateTime.now(), pe.getMessage(),  404, req.getRequestURL().toString());
		
		return new ResponseEntity<ErrorMessage>(erm, HttpStatus.NOT_FOUND);
	}
}
