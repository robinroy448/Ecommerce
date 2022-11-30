package com.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyerrorDetail> Exceptionn(CustomerException ex,WebRequest req){
		
		MyerrorDetail med = new MyerrorDetail(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(med,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyerrorDetail> Exceptionn(Exception ex,WebRequest req){
		
		MyerrorDetail med = new MyerrorDetail(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(med,HttpStatus.NOT_ACCEPTABLE);
	}
	
}
