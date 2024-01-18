package az.developia.springjava13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(path = "/add")
	public void addBook(@Valid @RequestBody Book b, BindingResult binding) {
		if (binding.hasErrors()) {
			throw new OurRuntimeException(binding);
		}
		System.out.println(b);
		repository.save(b);
	}
}
