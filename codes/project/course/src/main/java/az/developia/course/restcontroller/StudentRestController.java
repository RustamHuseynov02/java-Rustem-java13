package az.developia.course.restcontroller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
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

import az.developia.course.entity.Student;
import az.developia.course.repository.StudentRepository;
import az.developia.course.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentRestController {

	private final StudentService service;
	private final StudentRepository repository;

	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody Student s,BindingResult br) {
		ResponseEntity<Object> resp = service.add(s,br);
		return resp;
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		ResponseEntity<Object> resp = service.findAll();
		return resp;
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		ResponseEntity<Object> resp = service.delete(id);
		return resp;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id) {
		ResponseEntity<Object> resp = service.update(id);
		return resp;
	}
	


}
