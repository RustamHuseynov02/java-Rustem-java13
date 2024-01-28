package az.developia.springjava13.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DealerDTO {

	private Integer id;

	@Size(min = 2, max = 20, message = "2 ile 20 arasinda ad daxil edin")
	private String name;
	@Size(min = 2, max = 20, message = "2 ile 20 arasinda ad daxil edin")
	private String surname;
	@Size(min = 2, max = 20, message = "2 ile 20 arasinda ad daxil edin")
	private String username;
	@Size(min = 2, max = 20, message = "2 ile 20 arasinda ad daxil edin")
	private String password;
	@Pattern(regexp = "[a-z]+@[a-z]+\\.[a-z]{2,4}", message = "emaili duz yaz")
	private String email;
	@Size(min = 2, max = 20, message = "2 ile 20 arasinda ad daxil edin")
	private String type;
}
