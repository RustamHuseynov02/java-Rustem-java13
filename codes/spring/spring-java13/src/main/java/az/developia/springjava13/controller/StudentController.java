package az.developia.springjava13.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.response.StudentResponse;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public StudentResponse getList() {
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setStudents(repository.findAll()); // burada bizim studentResponse classimiz icinde olan
															// deyisenin setter metoduna findAll(hamisini
															// qaytaririq)bazada olan butun melumatlari
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
		
		StudentEntity entity = new StudentEntity();
		entity.setId(null);
		entity.setName(s.getName());
		entity.setSurname(s.getSurname());
		entity.setUsername(s.getUsername());
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
	public void update(@Valid @RequestBody StudentEntity p, BindingResult br) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
		// crud emeliyati
		if (p.getId() == null || p.getId() <= 0) {
			throw new OurRuntimeException(null, "id-ni duzgun qeyd edin"); // bu mapping bizim save olan data-mizi id
																			// sine gore goturub
		} // redakte ede bilir burada olan qaydalarda post demek olar ki eynidi
		if (repository.findById(p.getId()).isPresent()) {
			repository.save(p);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi ve uygun id deyil");
		}

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni ver silim
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}

		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}

	}

	@GetMapping("/{id}")
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
