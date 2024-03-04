package az.developia.course.restcontroller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.Authority;
import az.developia.course.entity.User;
import az.developia.course.exception.OurRuntimeException;
import az.developia.course.repository.AuthorityRepository;
import az.developia.course.repository.UserRepository;
import az.developia.course.request.UserAddRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserRestController {

	private final UserRepository repository;
	
	private final AuthorityRepository authorityRepository;
	
	@PostMapping
	public User add(@Valid @RequestBody UserAddRequest addUser,BindingResult br) {
		
		User user = new User();
		Optional<User> optional = repository.findById(addUser.getUsername());
		if (optional.isPresent()) {
			throw new OurRuntimeException(null, "Bu istifadəçi Adı var");
		}
		user.setUsername(addUser.getUsername());
		user.setPassword("{noop}"+addUser.getPassword());
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
