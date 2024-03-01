package az.developia.springjava13.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OwnerDTO {

	@Size(min = 2, max = 20,message = "Adi dogru daxil edin")
	private String name;
	
	@Size(min = 2, max = 20,message = "Soyadi dogru daxil edin")
	private String surname;
	
	@Size(min = 2, max = 20,message = "istifadeci Adini dogru daxil edin")
	private String username;
	
	@Size(min = 2, max = 20,message = "Sifreni dogru daxil edin")
	private String password;
	
	@Size(min = 2, max = 20,message = "emaili dogru daxil edin")
	private String email;
}
