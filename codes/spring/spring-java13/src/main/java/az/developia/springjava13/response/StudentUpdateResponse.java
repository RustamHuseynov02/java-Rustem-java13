package az.developia.springjava13.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentUpdateResponse {

	private String name;
	private String username;
	private String password;
}
