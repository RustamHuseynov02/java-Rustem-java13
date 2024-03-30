package az.developia.springjava13.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDTO {

	private Integer id;
	private String name;
	private String username;
	private String password;

	private Integer teacherId;
}
