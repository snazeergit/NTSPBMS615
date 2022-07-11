package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.ErrorDetails;

//@ControllerAdvice //old one
@RestControllerAdvice //latest one
public class ActorControllerAdvice {

	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFoundException anfe) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", anfe.getMessage());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", e.getMessage());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
