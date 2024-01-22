package az.developia.springjava13.handler;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class Handler {
	
	
//	@ExceptionHandler  bu annotasiyani 2 defe bir classin icinde istifade etmek olmur ancaq type vermelisen
//	public String handler2(OurRuntimeException exception) {
//		return exception.getBr().getFieldErrors().get(0).getDefaultMessage();
//	}

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
