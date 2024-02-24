package az.developia.springjava13.response;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentAddResponse {

	private Integer id;

	private String name;

	private String surname;

	private String email;
}
