package az.developia.springjava13.dto;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDTO {

	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String name;
	@Size(max = 30, min = 2, message = "sizin user adiniz qaydalara uygun deyil")
	private String username;
	@Size(max = 30, min = 2, message = "sizin sifreniz qaydalara uygun deyil")
	private String password;

	
	private Integer teacherId;
}

