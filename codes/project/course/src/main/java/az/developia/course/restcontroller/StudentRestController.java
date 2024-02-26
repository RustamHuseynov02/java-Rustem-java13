package az.developia.course.restcontroller;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.Student;
import az.developia.course.entity.StudentNote;
import az.developia.course.exception.OurRuntimeException;
import az.developia.course.repository.StudentNoteRepository;
import az.developia.course.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentRestController {

	private final StudentRepository repository;
	
	private final StudentNoteRepository noteRepository;

	@PostMapping
	public Student save(@Valid @RequestBody Student s,BindingResult br) {
        if (br.hasErrors()) {
			throw new OurRuntimeException(br,"Məlumat Səhvdir");
		}
		return repository.save(s);
	}

	@GetMapping
	public List<Student> findAll() {
		return repository.findAll();
	}

	@DeleteMapping(path = { "/{id}" })
	public void deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
		List<StudentNote> d = noteRepository.findAllByStudentId(id);
		noteRepository.deleteAll(d);
	}
	
	@GetMapping(path = "/{id}")
	public Student update(@PathVariable Integer id) {
		return repository.findById(id).get();
	}

}
