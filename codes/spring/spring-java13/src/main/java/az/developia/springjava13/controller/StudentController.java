package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.response.StudentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Api(description = "burada telebelerin crud emeliyyati olur")
public class StudentController {

	
	private final StudentRepository repository;
	
	private final UserRepository userRepo;
	
	private final TeacherRepository teacherRepository;
	
	private final AuthorityRepository authorityRepository;
	

	@GetMapping
	//@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	@ApiOperation(value = "burada mellimin id-sine gore butun telebeleri qaytarir",notes = "qeyd")
	public StudentResponse getList() {
		StudentResponse studentResponse = new StudentResponse();
		// burada bizim studentResponse classimiz icinde olan
		// deyisenin setter metoduna findAll(hamisini
		// qaytaririq)bazada olan butun melumatlari

		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		//TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		//Integer teacherId = operatorTeacher.getId();
		List<StudentEntity> list = repository.findAll();
		//Function<StudentEntity, String> s = new Function<StudentEntity, String>() {
			
//			@Override
//			public String apply(StudentEntity t) {
//				return t.getName();
//			}
//		};
//		
//		Predicate<String> p = new Predicate<String>() {
//			
//			@Override
//			public boolean test(String t) {
//				
//				return t.contains("a");
//			}
//		};
//		list.stream().map(s).filter(p).forEach((t)->System.out.println(t));
//		
		studentResponse.setStudents(list);

		studentResponse.setUsername("A4Tech");
		return studentResponse;

	}

	@PostMapping
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

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();

		if (s.getTeacherId() == teacherId) {
			throw new OurRuntimeException(null, "basqa mellimin idsi ile telebe qeyd etmek olmaz");
		}

		StudentEntity entity = new StudentEntity();
		entity.setId(null);
		entity.setName(s.getName());
		entity.setSurname(s.getSurname());
		entity.setUsername(s.getUsername());
		entity.setTeacherId(teacherId);
		System.out.println(s); 
		repository.save(entity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(s.getUsername());
		userEntity.setPassword(s.getPassword());
		userEntity.setType(s.getType());
		userEntity.setEmail(s.getEmail());
		userEntity.setEnabled(1);
		System.out.println(userEntity);
		userRepo.save(userEntity);
		
		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_GET_ID_STUDENT");
		authorityEntity.setUsername(userEntity.getUsername());
		authorityRepository.save(authorityEntity);
		
	}

	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_UPDATE_STUDENT')")
	public void update(@Valid @RequestBody StudentEntity s, BindingResult br) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
		// crud emeliyati
		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(br, "id-ni duzgun qeyd edin"); // bu mapping bizim save olan data-mizi id
																			// sine gore goturub
		} // redakte ede bilir 

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		if (operatorTeacher == null) {
			throw new OurRuntimeException(null, "Bele bir mellim tapilmadi");
		}
		Integer teacherId = operatorTeacher.getId();
		
		Optional<StudentEntity> finded = repository.findById(s.getId());
		if (finded.isPresent()) {
			StudentEntity entity = finded.get();
			if (entity.getTeacherId() == teacherId) {
				repository.save(s);
				userRepo.saveByUser(entity.getUsername());
			} 
			else {
				throw new OurRuntimeException(null, "Basqa telebeni update ede bilmezsiz");
			}
			
		} else {
			throw new OurRuntimeException(null, "id tapilmadi ve uygun id deyil");
		}

	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETE_STUDENT')")
	public void delete(@PathVariable Integer id) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni ver silim
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		
		
		
		StudentEntity en = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi"));
		
//		if (finded.isPresent()) {
//			StudentEntity en = finded.get();
			if (en.getTeacherId() == teacherId) {
				repository.deleteById(id);
            	userRepo.deleteById(en.getUsername());
            	authorityRepository.deleteByUserAuthorities(en.getUsername());
			}
			else {
				throw new OurRuntimeException(null, "bu telebeni sile bilmezsen");
			}
			
		} 
	

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GET_ID_STUDENT')")
	public StudentEntity findAllById(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}
		Optional<StudentEntity> o = repository.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

}
