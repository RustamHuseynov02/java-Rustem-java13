package az.developia.springjava13.request;

import az.developia.springjava13.annotation.myAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@ApiModel(description = "burasi gelen requesti qarsilayan yerdir ")
public class StudentAddRequest {

	private Integer id;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String name;
	@myAnnotation(value = "a")
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String surname;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String username;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String password;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	@ApiModelProperty(notes = "burada variablede")
	private String email;
	@Size(max = 30, min = 2, message = "sizin adiniz qaydalara uygun deyil")
	private String type;
	

}

