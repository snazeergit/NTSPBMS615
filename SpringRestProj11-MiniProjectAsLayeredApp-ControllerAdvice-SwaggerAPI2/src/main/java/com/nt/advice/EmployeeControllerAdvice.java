package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.ErrorAdvice;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorAdvice> adviceForEmployeeNotFoundException(EmployeeNotFoundException enfe) {
		ErrorAdvice errorAdvice = new ErrorAdvice(LocalDateTime.now(), "500", enfe.getMessage());
		return new ResponseEntity<ErrorAdvice>(errorAdvice, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorAdvice> adviceForEmployeeNotFoundException(Exception e) {
		ErrorAdvice errorAdvice = new ErrorAdvice(LocalDateTime.now(), "500", e.getMessage());
		return new ResponseEntity<ErrorAdvice>(errorAdvice, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
