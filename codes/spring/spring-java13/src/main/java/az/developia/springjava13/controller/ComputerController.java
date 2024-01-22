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

import az.developia.springjava13.component.Computer;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.ComputerRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/computers")
public class ComputerController {
	
	@Autowired
	private ComputerRepository repository;

	
	@GetMapping
	public List<Computer> listComputer(){
		return repository.findAll();
	}
	
	
	@PostMapping("/add")
	public void addComputer(@Valid @RequestBody Computer c,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(null, "Melumatin tamligi pozulub");
		}
		System.out.println(c);
		repository.save(c);
	}
	
	@PutMapping("/update")
	public void updateComputer(@Valid @RequestBody Computer c, BindingResult br) {
		if (c.getId() == null || c.getId() <= 0) {
			throw new OurRuntimeException(null, "id-ni dogru daxil edin");
		}
		if (repository.findById(c.getId()).isPresent()) {
			repository.save(c);
		}
		else {
			throw new OurRuntimeException(null, "bele bir id yoxdur");
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteComputer(@PathVariable Integer id) {
		if (id==null||id<=0) {
			throw new OurRuntimeException(null, "id-ni dogru qeyd edin");
		}
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		}
		else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
	
	@GetMapping("/{id}")
	public Computer findById(@PathVariable Integer id) {
		if (id==null || id<=0) {
			throw new OurRuntimeException(null, "id-ni dogru qeyd edin");
		}
		Optional<Computer> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
	
}
