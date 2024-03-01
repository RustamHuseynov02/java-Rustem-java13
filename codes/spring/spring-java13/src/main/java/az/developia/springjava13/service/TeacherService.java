package az.developia.springjava13.service;

import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

	private final TeacherRepository repository;
	
	public TeacherEntity entity(String username) {
		TeacherEntity t = repository.findByUsername(username);
		if (t==null) {
			throw new OurRuntimeException(null, "bele bir mellim tapilmadi");
		}
		
		return t;
	}

	
}
