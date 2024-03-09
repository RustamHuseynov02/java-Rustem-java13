package az.developia.springjava13.service;

import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.Users;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository repository;
	
	public Users username(String a) {
           Users user = repository.username(a);
		if (user==null) {
			throw new OurRuntimeException(null, "bele bir user yoxdur");
		}
		return user;
	}
}
