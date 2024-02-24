package az.developia.springjava13.service;

import org.springframework.stereotype.Service;

import az.developia.springjava13.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	
	

}
