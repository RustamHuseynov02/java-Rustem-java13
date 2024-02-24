package az.developia.springjava13.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import az.developia.springjava13.dto.StudentUpdateDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.response.StudentAddResponse;
import az.developia.springjava13.response.StudentDeleteResponse;
import az.developia.springjava13.response.StudentResponse;
import az.developia.springjava13.response.StudentUpdateResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Data
public class StudentService {

	private final StudentRepository repository;

	private final SecutiryService secutiryService;

	private final TeacherService teacherService;
	
	private final UserRepository userRepo;
	
	private final AuthorityRepository authorityRepository;
	
	
	
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

		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
		Integer teacherId = teacher.getId();

		List<StudentEntity> list = repository.findAllByTeacherId(teacherId);

		studentResponse.setStudents(list);

		studentResponse.setUsername("A4Tech");
		return ResponseEntity.ok(studentResponse);

	}

	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest s, BindingResult br) { // burada valid annotasiyasi gelen
		// requestin dogrulunu yoxlayir eger webden
		// gelen sorgu
// @valid-in qoydugu qaydalara uygun deyilse
// br.hasErrors true qaytarir ve bizim exception-miz calisir
		if (br.hasErrors()) { // bizim exception icinde bindingresult qebul eden constructor var
			throw new OurRuntimeException(br, "melumatin tamligi pozulub");// exception xetani alir @ExceptionHandler
			// annotasiya altinda olan metodun
		} // parametresine daxil olur orada xetani daha optimize bir sekilde gosterir

		TeacherEntity teacher = teacherService.entity(secutiryService.findByUsername());
		Integer teacherId = teacher.getId();

		

		StudentEntity entity = new StudentEntity();
		entity.setName(s.getName());
		entity.setSurname(s.getSurname());
		entity.setUsername(s.getUsername());
		entity.setTeacherId(teacherId);
		repository.save(entity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(s.getUsername());
		userEntity.setPassword(s.getPassword());
		userEntity.setType(s.getType());
		userEntity.setEmail(s.getEmail());
		userEntity.setEnabled(1);
		userRepo.save(userEntity);

		AuthorityEntity authorityEntity = new AuthorityEntity();
		authorityEntity.setAuthority("ROLE_GET_ID_STUDENT");
		authorityEntity.setUsername(userEntity.getUsername());
		authorityRepository.save(authorityEntity);
		
	    StudentAddResponse resp = new StudentAddResponse();
	    resp.setEmail(userEntity.getEmail());
	    resp.setId(entity.getId());
	    resp.setName(entity.getName());
	    resp.setSurname(entity.getSurname());
	    
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
				
				StudentEntity en = repository.findById(dto.getId()).orElseThrow(()->new OurRuntimeException(null, "bele bir telebe tapilmadi"));
			    en.setName(dto.getName());
			    en.setUsername(dto.getUsername());
				en.setTeacherId(dto.getTeacherId());
				
				UserEntity user = new UserEntity();
				user.setUsername(dto.getUsername());
				user.setPassword(dto.getPassword());
				
				AuthorityEntity auEntity = new AuthorityEntity();
				auEntity.setUsername(dto.getUsername());
					if (en.getTeacherId() == teacherId) {
						repository.save(en);
						userRepo.save(user);
						authorityRepository.save(auEntity);
					} 
					else {
						throw new OurRuntimeException(null, "Basqa telebeni update ede bilmezsiz");
					}		

					StudentUpdateResponse response = new StudentUpdateResponse();
					response.setName(dto.getName());
					response.setUsername(dto.getUsername());
					response.setPassword(dto.getPassword());
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
					if (en.getTeacherId() == teacherId) {
						repository.deleteById(id);
		            	userRepo.deleteById(en.getUsername());
		            	authorityRepository.deleteByUserAuthorities(en.getUsername());
					}
					else {
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
			if (en.getTeacherId()==teacherId) {
				return ResponseEntity.ok(optional.get());
			}
			else {
				throw new OurRuntimeException(null, "bu telebeni cagira bilmezsen");
			}
			
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

}
