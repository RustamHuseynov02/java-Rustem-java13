package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

	private List<StudentEntity> students;

	private String username;

	
}
