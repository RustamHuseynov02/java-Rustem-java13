package az.developia.springjava13.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.DealerDTO;
import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.DealerEntity;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.DealerRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

	private final TeacherRepository repository;
	
	private final UserRepository userRepository;

	private final DealerRepository dealerRepository;
	
	private final AuthorityRepository authorityRepository;
	
	private final StudentRepository studentRepository;
	
	
	@PostMapping(path = "/teacher")
	public void createTeacher(@RequestBody TeacherDTO t) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
		String raw = t.getPassword();
		String pass = "{bcrypt}" + encoder.encode(raw);
		userEntity.setPassword(pass);
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
	
	@PostMapping("/student")
	@PreAuthorize(value = " hasAuthority('ROLE_ADD_STUDENT')")
	public void add(@Valid @RequestBody StudentDTO s, BindingResult br) { // burada valid annotasiyasi gelen
																			// requestin dogrulunu yoxlayir eger webden
																			// gelen sorgu
		// @valid-in qoydugu qaydalara uygun deyilse
		// br.hasErrors true qaytarir ve bizim exception-miz calisir
		if (br.hasErrors()) { // bizim exception icinde bindingresult qebul eden constructor var
			throw new OurRuntimeException(br, "melumatin tamligi pozulub");// exception xetani alir @ExceptionHandler
																			// annotasiya altinda olan metodun
		} // parametresine daxil olur orada xetani daha optimize bir sekilde gosterir

		
		Optional<UserEntity> o = userRepository.findById(s.getUsername());
		if (o.isPresent()) {
			throw new OurRuntimeException(null, "bu username artiq istifade olunub");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = repository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (s.getTeacherId() == teacherId) {
			throw new OurRuntimeException(null, "basqa mellimin idsi ile telebe qeyd etmek olmaz");
		}

		StudentEntity entity = new StudentEntity();
		entity.setName(s.getName());
		entity.setSurname(s.getSurname());
		entity.setUsername(s.getUsername());
		entity.setTeacherId(teacherId);
		studentRepository.save(entity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(s.getUsername());
		String raw = s.getPassword();
		String pass = "{bcrypt}" + encoder.encode(raw);
		userEntity.setPassword(pass);
		userEntity.setType(s.getType());
		userEntity.setEmail(s.getEmail());
		userEntity.setEnabled(1);
		userRepository.save(userEntity);
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_GET_ID_STUDENT");
		authorityEntity.setUsername(userEntity.getUsername());
		authorityRepository.save(authorityEntity);
		
	}

	
}
