package az.developia.course.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.Authority;
import az.developia.course.entity.User;
import az.developia.course.repository.AuthorityRepository;
import az.developia.course.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserRestController {

	private final UserRepository repository;
	
	private final AuthorityRepository authorityRepository;
	
	@PostMapping
	public User add(@RequestBody User user) {
		user.setPassword("{noop}"+user.getPassword());
		user.setEnabled(true);
		User entity = repository.save(user);
		
		Authority authority = new Authority();
		authority.setUsername(user.getUsername());
		authority.setAuthority("teacher");
		authorityRepository.save(authority);
		
		return entity;
	}
	
	@GetMapping(path = "/login")
	public void login() {
		
	}
}
