package az.developia.course.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

	private List<ErrorResponse> validations;
	
}
