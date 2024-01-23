package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Student;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.StudentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping
	public List<Student> getList() {

		return repository.findAll();

	}

	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Student p, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatin tamligi pozulub");
		}
		System.out.println(p);
		repository.save(p);
	}

	@PutMapping("/update")
	public void update(@Valid @RequestBody Student p, BindingResult br) {
		// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
		// crud emeliyati
		if (p.getId() == null || p.getId() <= 0) {
			throw new OurRuntimeException(null, "id-ni duzgun qeyd edin");
		}
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
	public Student findAllById(@PathVariable Integer id) {
		if (id == null || id <= 0) {
             throw new OurRuntimeException(null, "id yanlisdir duzgun qeyd edin");
		}
		Optional<Student> o = repository.findById(id);
		if (o.isPresent()) {
			return o.get();
		}
		else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

}
