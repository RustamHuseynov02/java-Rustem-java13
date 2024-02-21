package az.developia.springjava13.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeacherDTO {

	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String name;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String surname;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String username;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String password;
	@Pattern(regexp = "[a-z]+@[a-z]+\\.[a-z]{2,4}", message = "emaili duz yaz")
	private String email;
	
}
