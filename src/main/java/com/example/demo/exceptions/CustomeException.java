package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomeException {

	
	@ExceptionHandler(exception = CourseException.class)
	public ResponseEntity<ErrorMessage> productException(CourseException pe, HttpServletRequest req) {
		
		   ErrorMessage erm = new ErrorMessage(LocalDateTime.now(), pe.getMessage(),  404, req.getRequestURL().toString());
		
		return new ResponseEntity<ErrorMessage>(erm, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> productException(MethodArgumentNotValidException me, WebRequest req) {
		
		   ErrorMessage erm = new ErrorMessage(LocalDateTime.now(), me.getBindingResult().getFieldError().getDefaultMessage(),  404, req.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(erm, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorMessage> productException(NoHandlerFoundException no, WebRequest req) {
		
		   ErrorMessage erm = new ErrorMessage(LocalDateTime.now(), no.getMessage(),  404, req.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(erm, HttpStatus.NOT_FOUND);
	}
	
//	 @ExceptionHandler(BatchNotFoundException.class)
//	    public ResponseEntity<String> handleBatchNotFoundException(BatchNotFoundException ex) {
//	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	    }

}
