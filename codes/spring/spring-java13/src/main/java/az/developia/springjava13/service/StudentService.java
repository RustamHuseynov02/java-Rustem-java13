package az.developia.springjava13.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import az.developia.springjava13.dto.StudentUpdateDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.entity.Users;
import az.developia.springjava13.entity.ViewEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.repository.ViewRepository;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.response.StudentAddResponse;
import az.developia.springjava13.response.StudentDeleteResponse;
import az.developia.springjava13.response.StudentResponse;
import az.developia.springjava13.response.StudentUpdateResponse;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Data
public class StudentService {

	private final StudentRepository repository;

	private final SecutiryService secutiryService;

	private final TeacherService teacherService;
	
	private final UserService userService;
	
	private final UsersService usersService;
	
	private final ViewRepository viewRepository;

	private final UserRepository userRepo;

	private final AuthorityRepository authorityRepository;

	private final ModelMapper mapper;

	public ResponseEntity<Object> findAll() {
		StudentResponse response = new StudentResponse();

		if (response.getStudents() == null) {
			throw new OurRuntimeException(null, "Telebeler tapilmadi");
		}
		
		List<StudentEntity> s = repository.findAll();

		response.setStudents(s);
		response.setUsername("aaa");
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<Object> findAllById() {
		StudentResponse studentResponse = new StudentResponse();

//		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
//		Integer teacherId = teacher.getId();

		List<ViewEntity> view = viewRepository.findAll();
		System.out.println(view);
		//List<StudentEntity> list = repository.findAllByCreator(teacherId);

		//studentResponse.setStudents(list);

		studentResponse.setUsername("A4Tech");
		return ResponseEntity.ok(studentResponse);

	}

	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest s, BindingResult br) { // burada valid
																									// annotasiyasi
																									// gelen
		// requestin dogrulunu yoxlayir eger webden
		// gelen sorgu
// @valid-in qoydugu qaydalara uygun deyilse
// br.hasErrors true qaytarir ve bizim exception-miz calisir
		if (br.hasErrors()) { // bizim exception icinde bindingresult qebul eden constructor var
			throw new OurRuntimeException(br, "melumatin tamligi pozulub");// exception xetani alir @ExceptionHandler
			// annotasiya altinda olan metodun
		} // parametresine daxil olur orada xetani daha optimize bir sekilde gosterir

		Users users = usersService.username(secutiryService.findByUsername());
		Integer userId = users.getUserId();
		String usersType = users.getType();

		StudentEntity entity = new StudentEntity();
		mapper.map(s, entity);
		entity.setCreator(userId);
		entity.setCreatorType(usersType);
		repository.save(entity);

		UserEntity userEntity = new UserEntity();
		mapper.map(s, userEntity);
		userEntity.setEnabled(1);
		userRepo.save(userEntity);

		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_GET_ID_STUDENT");
		authorityEntity.setUsername(userEntity.getUsername());
		authorityRepository.save(authorityEntity);

		StudentAddResponse resp = new StudentAddResponse();
		resp.setEmail(userEntity.getEmail());
		mapper.map(entity, resp);

		return ResponseEntity.ok(resp);

	}

	public ResponseEntity<Object> findByIdtoUpdate(@Valid @RequestBody StudentUpdateDTO dto, BindingResult br) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
		// crud emeliyati
		if (dto.getTeacherId() == null || dto.getTeacherId() <= 0) {
			throw new OurRuntimeException(br, "id-ni duzgun qeyd edin"); // bu mapping bizim save olan data-mizi id
																			// sine gore goturub
		} // redakte ede bilir
		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
		if (teacher == null) {
			throw new OurRuntimeException(null, "Bele bir mellim tapilmadi");
		}
		Integer teacherId = teacher.getId();
		
		StudentEntity en = repository.findById(dto.getId()).orElseThrow(() -> new OurRuntimeException(null, "bele bir telebe tapilmadi"));
		mapper.map(dto, en);

		UserEntity user = new UserEntity();
		mapper.map(dto, user);

		AuthorityEntity auEntity = new AuthorityEntity();
		auEntity.setUsername(dto.getUsername());
		if (en.getCreator() == teacherId) {
			repository.save(en);
			userRepo.save(user);
			authorityRepository.save(auEntity);
		} else {
			throw new OurRuntimeException(null, "Basqa telebeni update ede bilmezsiz");
		}

		StudentUpdateResponse response = new StudentUpdateResponse();
		mapper.map(dto, response);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<Object> findByIdToDelete(Integer id) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni ver silim
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}
		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
		if (teacher == null) {
			throw new OurRuntimeException(null, "bele bir mellim tapilmadi");
		}
		Integer teacherId = teacher.getId();

		StudentEntity en = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi"));
		if (en.getCreator() == teacherId) {
			repository.deleteById(id);
			userRepo.deleteById(en.getUsername());
			authorityRepository.deleteByUserAuthorities(en.getUsername());
		} else {
			throw new OurRuntimeException(null, "bu telebeni sile bilmezsen");
		}

		StudentDeleteResponse response = new StudentDeleteResponse();
		response.setId(id);
		response.setUsername(en.getUsername());
		response.setMessage("bu telebe silindi");

		return ResponseEntity.ok(response);
	}

	public ResponseEntity<Object> findById(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}
		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
		if (teacher == null) {
			throw new OurRuntimeException(null, "bele bir mellim tapilmadi");
		}
		Integer teacherId = teacher.getId();
		Optional<StudentEntity> optional = repository.findById(id);
		if (optional.isPresent()) {
			StudentEntity en = optional.get();
			if (en.getCreator() == teacherId) {
				return ResponseEntity.ok(optional.get());
			} else {
				throw new OurRuntimeException(null, "bu telebeni cagira bilmezsen");
			}

		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	public ResponseEntity<Object> findPagination(Integer begin, Integer length) {
		List<StudentEntity> en = repository.findPagination(begin,length);
		return ResponseEntity.ok(en);
	}

}
