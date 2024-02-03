package az.developia.springjava13.dto;


import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {

	@Size(max = 20, min = 1, message = "kitabin adini dogru girin")
	private String name;
	private Double price;
	private Integer pageCount;
	@Size(max = 20, min = 1, message = "yazicin adini dogru girin")
	private String author;
}
