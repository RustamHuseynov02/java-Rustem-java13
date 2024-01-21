package az.developia.springjava13.handler;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler
	public String handler(OurRuntimeException o) {
		BindingResult br = o.getBr();
		if (o.getBr()==null) {
			
		}
		else {
			
		}
		
		return o.getMessage();
	}
}
