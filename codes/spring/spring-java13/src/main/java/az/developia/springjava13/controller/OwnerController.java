package az.developia.springjava13.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.repository.OwnerRepository;
import az.developia.springjava13.response.OwnerResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/owners")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerRepository repository;
	
	@GetMapping
	public OwnerResponse getList() {
		OwnerResponse response = new OwnerResponse();
		response.setList(repository.findAll());
		
		return response;
	}
	
}
