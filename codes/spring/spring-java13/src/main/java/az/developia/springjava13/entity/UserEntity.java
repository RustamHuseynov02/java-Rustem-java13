package az.developia.springjava13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class UserEntity {

	@Id
	private String username;
	
	private String password;
	
	private String email;
	
	private Integer enabled;
	
	private String type;
}
