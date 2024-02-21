package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DealerResponse {

	private List<BookEntity> books;
	

	
}
