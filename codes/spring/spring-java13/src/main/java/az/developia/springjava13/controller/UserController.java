package az.developia.springjava13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.DealerDTO;
import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.DealerEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.DealerRepository;
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
	@Autowired
	private DealerRepository dealerRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	
	
	@PostMapping(path = "/teacher")
	public void createTeacher(@RequestBody TeacherDTO t) {
		
		Optional<UserEntity> o = userRepository.findById(t.getUsername());
		if (o.isPresent()) {
			throw new OurRuntimeException(null, "bu username artiq istifade olunub");
		}
		
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

		
		
		AuthorityEntity a = new AuthorityEntity();
		a.setUsername(userEntity.getUsername());
		a.setAuthority("ROLE_ADD_STUDENT");
		authorityRepository.save(a);
		
		
	}
	
	@PostMapping(path = "/seller")
	public void createDealer(@RequestBody DealerDTO d) {
		
		Optional<UserEntity> o = userRepository.findById(d.getUsername());  // burada biz userRepo sayesinde dtomuzun usernameni primary edirik
		if (o.isPresent()) {
			throw new OurRuntimeException(null, "bu username artiq istifade olunub");
		}
		
		DealerEntity dealerEntity = new DealerEntity();
		dealerEntity.setId(null);
		dealerEntity.setName(d.getName());
		dealerEntity.setSurname(d.getSurname());
		dealerEntity.setUsername(d.getUsername());
		dealerRepository.save(dealerEntity);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(d.getUsername());
		userEntity.setPassword(d.getPassword());
		userEntity.setEmail(d.getEmail());
		userEntity.setType("dealer");
		userEntity.setEnabled(1);
		userRepository.save(userEntity);
		
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setId(null);
		authorityEntity.setUsername(userEntity.getUsername());
		authorityEntity.setAuthority("ROLE_ADD_BOOK");
		authorityRepository.save(authorityEntity);
		
		
	}
	
	
	@GetMapping
	public void login() {
		
	}
	
}
