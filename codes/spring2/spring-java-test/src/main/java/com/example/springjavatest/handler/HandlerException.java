package com.example.springjavatest.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springjavatest.exception.OurRuntimeException;

@RestControllerAdvice
public class HandlerException {

	@ExceptionHandler
	public String handle(OurRuntimeException o) {
		return o.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	}
	
}
