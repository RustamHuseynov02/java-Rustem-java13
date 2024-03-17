package az.developia.springjava13.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.repository.BookRepository;
import az.developia.springjava13.repository.DealerRepository;
import az.developia.springjava13.response.DealerResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "sellers")
@RequiredArgsConstructor
public class DealerController {

	private final BookRepository bookRepository;
	
	private final DealerRepository repository;
	
	
	@GetMapping
	public DealerResponse getList() {
		DealerResponse response = new DealerResponse();
		
	
		
		List<BookEntity> s = bookRepository.findAll();
		
		response.setBooks(s);
		
		
		return response;
	}
}
