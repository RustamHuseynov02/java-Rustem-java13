package az.developia.springjava13.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDeleteResponse {

      private Integer id;	
      private String username;
	  private String message; 
}
