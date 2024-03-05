package az.developia.course.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import az.developia.course.entity.Student;
import az.developia.course.entity.StudentNote;
import az.developia.course.exception.OurRuntimeException;
import az.developia.course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;
	
	private final StudentNoteService noteService;

	private final SecurityService securityService;
	
	public ResponseEntity<Object> add(@Valid @RequestBody Student s ,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br,"Məlumat Səhvdir");
		}
		Student students = new Student();
		students.setName(s.getName());
		students.setSurname(s.getSurname());
		students.setProfilePhoto(s.getProfilePhoto());
		students.setTeacher(securityService.getUser());
        repository.save(students);
		
		return ResponseEntity.ok(students);
	}

	public ResponseEntity<Object> findAll() {
		List<Student> students = repository.findAllByTeacher(securityService.getUser());
		return ResponseEntity.ok(students);
	}
	
	 

	public ResponseEntity<Object> delete(Integer id) {
		repository.deleteById(id);
		List<StudentNote> d = noteService.findAllByStudentListId(id);
		noteService.deleteAll(d);
		return ResponseEntity.ok(null);
	}

	public ResponseEntity<Object> update(Integer id) {
		Student students = repository.findById(id).get();
		return ResponseEntity.ok(students);
	}
	
	
	
	
}
