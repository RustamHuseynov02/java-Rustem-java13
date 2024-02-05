package az.developia.springjava13.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.response.StudentResponse;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	@Autowired
	private UserRepository userRepo;
	@Autowired 
	private TeacherRepository teacherRepository;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public StudentResponse getList() {
		StudentResponse studentResponse = new StudentResponse();
		                                                    // burada bizim studentResponse classimiz icinde olan
															// deyisenin setter metoduna findAll(hamisini
															// qaytaririq)bazada olan butun melumatlari
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		List<StudentEntity> list = repository.findAllByTeacherId(teacherId);
		studentResponse.setStudents(list);
		
		studentResponse.setUsername("A4Tech");
		return studentResponse;

	}	

	@PostMapping
	@PreAuthorize(value = " hasAuthority('ROLE_ADD_STUDENT')")
	public void add(@Valid @RequestBody StudentDTO s, BindingResult br) { // burada valid annotasiyasi gelen
																		// requestin dogrulunu yoxlayir eger webden gelen sorgu
		                          // @valid-in qoydugu qaydalara uygun deyilse
		                        // br.hasErrors true qaytarir ve bizim exception-miz calisir
		if (br.hasErrors()) { // bizim exception icinde bindingresult qebul eden constructor var
			throw new OurRuntimeException(br, "melumatin tamligi pozulub");// exception xetani alir @ExceptionHandler
																			// annotasiya altinda olan metodun
		}                                                        // parametresine daxil olur orada xetani daha optimize bir sekilde gosterir
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		
		if (s.getTeacherId()!= teacherId) {
			throw new OurRuntimeException(null, "basqa mellimin idsi ile telebe qeyd etmek olmaz");
		}
		
		StudentEntity entity = new StudentEntity();
		entity.setId(null);
		entity.setName(s.getName());
		entity.setSurname(s.getSurname());
		entity.setUsername(s.getUsername());
		entity.setTeacherId(teacherId);
		System.out.println(s);                                        // daha da yaxsi oyrenmek istesen ora bax
		repository.save(entity);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(s.getUsername());
		userEntity.setPassword(s.getPassword());
		userEntity.setType(s.getType());
		userEntity.setEmail(s.getEmail());
		userEntity.setEnabled(1);
		System.out.println(userEntity);
		userRepo.save(userEntity);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_UPDATE_STUDENT')")
	public void update(@Valid @RequestBody StudentEntity s, BindingResult br,StudentDTO d) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
		// crud emeliyati
		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(br, "id-ni duzgun qeyd edin"); // bu mapping bizim save olan data-mizi id
																			// sine gore goturub
		} // redakte ede bilir burada olan qaydalarda post demek olar ki eynidi
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		
		if (d.getTeacherId()!= teacherId) {
			throw new OurRuntimeException(null, "bu telebeni update ede bilmezsen");
		}
		
		if (repository.findById(s.getId()).isPresent()) {
		    s.setTeacherId(teacherId);
			repository.save(s);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi ve uygun id deyil");
		}

	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETE_STUDENT')")
	public void delete(@PathVariable Integer id,StudentEntity s,StudentDTO d) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni ver silim
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();
		
		if (d.getTeacherId()!=teacherId) {
			throw new OurRuntimeException(null,"bu telebeni sile bilmezsen" );
		}

		if (repository.findById(id).isPresent()) {
			s.setTeacherId(teacherId);
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
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
