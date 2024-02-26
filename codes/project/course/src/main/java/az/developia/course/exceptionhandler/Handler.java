package az.developia.course.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.course.exception.OurRuntimeException;
import az.developia.course.response.ErrorResponse;
import az.developia.course.response.ExceptionResponse;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleException(OurRuntimeException exception) {
		BindingResult br = exception.getBr();
         ExceptionResponse response = new ExceptionResponse();
         List<ErrorResponse> errors = new ArrayList<>();
         for (FieldError error : br.getFieldErrors()) {
			 ErrorResponse errorResponse = new ErrorResponse();
			 errorResponse.setField(error.getField());
			 errorResponse.setMessage(error.getDefaultMessage());
			 errors.add(errorResponse);
		}
         response.setValidations(errors);
         return response;
	}
}
