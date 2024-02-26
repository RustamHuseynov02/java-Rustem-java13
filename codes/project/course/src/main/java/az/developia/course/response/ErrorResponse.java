package az.developia.course.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
 
	private String field;
	
	private String message;
}
