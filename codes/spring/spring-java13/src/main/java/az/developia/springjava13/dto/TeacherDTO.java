package az.developia.springjava13.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {

	@Min(value = 0 , message = "menfi olmaz" )
	private Integer id;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String name;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String surname;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String username;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String password;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String email;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String type;
	
	private Integer enabled;
}
