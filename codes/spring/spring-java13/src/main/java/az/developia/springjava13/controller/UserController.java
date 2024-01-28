package az.developia.springjava13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private TeacherRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path = "/teacher")
	public void createTeacher(@RequestBody TeacherDTO t) {
		TeacherEntity entity = new TeacherEntity();
		entity.setId(null);
		entity.setName(t.getName());
		entity.setSurname(t.getSurname());
		entity.setUsername(t.getUsername());
		repository.save(entity);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(t.getUsername());
		userEntity.setPassword(t.getPassword());
		userEntity.setEmail(t.getEmail());
		userEntity.setType("teacher");
		userEntity.setEnabled(1);
		userRepository.save(userEntity);
		
		
		
	}
	
	
	@GetMapping
	public void login() {
		
	}
	
}
