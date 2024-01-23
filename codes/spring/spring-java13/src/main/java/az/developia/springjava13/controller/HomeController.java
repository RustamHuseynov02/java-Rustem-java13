package az.developia.springjava13.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Home;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.HomeRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeRepository repository;

	@GetMapping
	public String showHome() {
		return "Home";
	}

	
	@PostMapping("/add")
	public void add(@Valid @RequestBody Home h,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(null, "Melumatin tamligi pozulub");
		}
		
		repository.save(h);
		System.out.println(h);
	}
	
	@PutMapping("/update")
	public void update(@Valid @RequestBody Home h,BindingResult br) {
		if (h.getId()==null || h.getId()<=0) {
			throw new OurRuntimeException(null, "id-ni dogru qeyd edin");
		}
		if (repository.findById(h.getId()).isPresent()) {
			repository.save(h);
		}
		else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
}
