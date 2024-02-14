package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.entity.OwnerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponse {

	List<OwnerEntity> list;
	
	
}
