package com.example.springjavatest.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException {

	private BindingResult bindingResult;
	
	
	public OurRuntimeException(BindingResult br) {
		this.bindingResult = br;
	}


	public BindingResult getBindingResult() {
		return bindingResult;
	}

	
	
}
