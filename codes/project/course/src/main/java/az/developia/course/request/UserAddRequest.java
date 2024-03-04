package az.developia.course.request;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAddRequest {

	@Size(min = 2,message = "İstifadəçi Adını Doğru daxil edin.Minimum 2 max 20 olmalıdı")
	private String username;
	
	private Integer password;
	
	
}
