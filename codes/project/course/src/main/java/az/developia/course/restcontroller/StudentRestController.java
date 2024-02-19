package az.developia.course.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.Student;
import az.developia.course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentRestController {

	private final StudentRepository repository;

	@PostMapping
	public Student save(@RequestBody Student s) {

		return repository.save(s);
	}

	@GetMapping
	public List<Student> findAll() {
		return repository.findAll();
	}

	@DeleteMapping(path = { "/{id}" })
	public void deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public Student update(@PathVariable Integer id) {
		return repository.findById(id).get();
	}

}
