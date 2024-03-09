package az.developia.springjava13.controller;

import java.util.Optional;

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

import az.developia.springjava13.dto.AdminDTO;
import az.developia.springjava13.dto.DealerDTO;
import az.developia.springjava13.dto.OwnerDTO;
import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.AdminEntity;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.DealerEntity;
import az.developia.springjava13.entity.OwnerEntity;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.entity.Users;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AdminRepository;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.DealerRepository;
import az.developia.springjava13.repository.OwnerRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.repository.UsersRepository;
import jakarta.validation.Valid;
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
	
	private final OwnerRepository ownerRepository;
	
	private final AdminRepository adminRepository;
	
	private final UsersRepository usersRepository;
	
	
	@PostMapping(path = "/admin")
	public void addAdmin(@Valid @RequestBody AdminDTO a,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatin tamliginda problem var");
		}
		
		Optional<UserEntity> check = userRepository.findById(a.getUsername());
		if (check.isPresent()) {
			throw new OurRuntimeException(null, "bu username artiq istifade olunub");
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		AdminEntity entity = new AdminEntity();
		entity.setName(a.getName());
		entity.setSurname(a.getSurname());
		entity.setUsername(a.getUsername());
        adminRepository.save(entity);
        
        
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(a.getUsername());
        String raw = a.getPassword();
        String pass = "{bcrypt}" + encoder.encode(raw);
        userEntity.setPassword(pass);
        userEntity.setEmail(a.getEmail());
        userEntity.setEnabled(1);
        userEntity.setType("Admin");
        userRepository.save(userEntity);
        
        Users users = new Users();
		users.setUsername(a.getUsername());
		users.setType(userEntity.getType());
		usersRepository.save(users);
        
        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setAuthority("ROLE_ADD_STUDENT");
        authorityEntity.setUsername(userEntity.getUsername());
        authorityRepository.save(authorityEntity);
		
		
		
	}
	
	
	
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

		Users users = new Users();
		users.setUsername(t.getUsername());
		users.setType(userEntity.getType());
		usersRepository.save(users);
		
		
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
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		DealerEntity dealerEntity = new DealerEntity();
		dealerEntity.setId(null);
		dealerEntity.setName(d.getName());
		dealerEntity.setSurname(d.getSurname());
		dealerEntity.setUsername(d.getUsername());
		dealerRepository.save(dealerEntity);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(d.getUsername());
		String raw = d.getPassword();
		String pass = "{bcrypt}" + encoder.encode(raw);
		userEntity.setPassword(pass);
		userEntity.setEmail(d.getEmail());
		userEntity.setType("seller");
		userEntity.setEnabled(1);
		userRepository.save(userEntity);
		
		Users users = new Users();
		users.setUsername(d.getUsername());
		users.setType(userEntity.getType());
		usersRepository.save(users);
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setId(null);
		authorityEntity.setUsername(userEntity.getUsername());
		authorityEntity.setAuthority("ROLE_GET_ALL_BOOK");
		authorityEntity.setAuthority("ROLE_GET_ID_BOOK");
		authorityRepository.save(authorityEntity);
		
		
	}
	
	
	@GetMapping
	public void login() {
		
	}
	
	@PostMapping("/student")
	@PreAuthorize(value = " hasAuthority('ROLE_ADD_STUDENT')")
	public void createStudent(@Valid @RequestBody StudentDTO s, BindingResult br) { // burada valid annotasiyasi gelen
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
		entity.setCreator(teacherId);
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
		
		Users users = new Users();
		users.setUsername(s.getUsername());
		users.setType(userEntity.getType());
		usersRepository.save(users);
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_GET_ID_STUDENT");
		authorityEntity.setUsername(userEntity.getUsername());
		authorityRepository.save(authorityEntity);
		
	}
	
	 
	
	@PostMapping(path = "/owner")
	public boolean createOwner(@Valid @RequestBody OwnerDTO o,BindingResult br) {
		
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumati dogru daxil edin");
		}
		
		Optional<UserEntity> optional = userRepository.findById(o.getUsername());
		if (optional.isPresent()) {
			throw new OurRuntimeException(null, "bu username artiq istifade olunub");
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		OwnerEntity ownerEntity = new OwnerEntity();
		ownerEntity.setName(o.getName());
		ownerEntity.setSurname(o.getSurname());
		ownerEntity.setUsername(o.getUsername());
		ownerRepository.save(ownerEntity);
		
		UserEntity entity = new UserEntity();
		entity.setUsername(o.getUsername());
		String raw = o.getPassword();
		String pass = "{bcrypt}" + encoder.encode(raw);
		entity.setPassword(pass);
		entity.setEmail(o.getEmail());
		entity.setEnabled(1);
		entity.setType("Owner");
		userRepository.save(entity);
		
		Users users = new Users();
		users.setUsername(o.getUsername());
		users.setType(entity.getType());
		usersRepository.save(users);
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_ADD_BOOK");
		authorityEntity.setUsername(entity.getUsername());
		authorityRepository.save(authorityEntity);
		
		
		return true;
	}
	

	
	
}
