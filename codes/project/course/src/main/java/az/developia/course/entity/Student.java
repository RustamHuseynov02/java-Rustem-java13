
package az.developia.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2,max = 20,message = "Adı doğru daxil edin")
	private String name;
	@Size(min = 2,max = 20,message = "Soyadı doğru daxil edin")
	private String surname; 
	
	private String profilePhoto;
	
	private String teacher;
}

