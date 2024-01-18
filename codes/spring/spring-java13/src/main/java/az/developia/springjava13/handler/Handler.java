package az.developia.springjava13.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler
	public String handler(OurRuntimeException o) {
		return o.getBr().getFieldErrors().get(0).getDefaultMessage();
	}
}
