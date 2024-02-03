package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import az.developia.springjava13.dto.BookDTO;
import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public List<BookEntity> findAllById() {
		return repository.findAll();
	}

	@PostMapping(path = "/add")
    @PreAuthorize(value = " hasAuthority('ROLE_ADD_BOOK')")
	// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
	// crud emeliyati
	public void addBook(@Valid @RequestBody BookDTO b, BindingResult binding) {
		if (binding.hasErrors()) {
			throw new OurRuntimeException(null, "Melumati duzgun qeyd edin");
		}
		System.out.println(b);
		
		BookEntity entity = new BookEntity();
		entity.setName(b.getName());
		entity.setAuthor(b.getAuthor());
		entity.setPrice(b.getPrice());
		entity.setPageCount(b.getPageCount());
		repository.save(entity);
	}

	@PutMapping("update")
	public void update(@RequestBody BookEntity b, BindingResult binding) {
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
	public BookEntity findById(@PathVariable Integer id) {
		if (id == 0 || id <= 0) {
			throw new OurRuntimeException(null, "id-ni duzgun qeyd edin");
		}
		Optional<BookEntity> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
}
