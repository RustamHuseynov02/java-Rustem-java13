package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Book;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookRepository repository;

	
	@GetMapping
	public List<Book> findAllById(){
		return repository.findAll();
	}
	
	@PostMapping(path = "/add")
	// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
	// crud emeliyati
	public void addBook(@Valid @RequestBody Book b, BindingResult binding) {
		if (binding.hasErrors()) {
			throw new OurRuntimeException(null, "Melumati duzgun qeyd edin");
		}
		System.out.println(b);
		repository.save(b);
	}

	@PutMapping("update")
	public void update(@RequestBody Book b, BindingResult binding) {
		if (b.getId() == null || b.getId() <= 0) {
			throw new OurRuntimeException(null, "id dogru qeyd edin");
		}
		if (repository.findById(b.getId()).isPresent()) {
			repository.save(b);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id duzgun qeyd edin");
		}
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable Integer id) {
		if (id == 0 || id <= 0) {
			throw new OurRuntimeException(null, "id-ni duzgun qeyd edin");
		}
		Optional<Book> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
}
