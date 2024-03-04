package az.developia.springjava13.service;

import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	public UserEntity findByUsername(String findByUsername) {
		UserEntity user = repository.getById(findByUsername);
		if (user==null) {
			throw new OurRuntimeException(null, "bele bir user yoxdur");
		}
		return user;
	}
	
	

}
