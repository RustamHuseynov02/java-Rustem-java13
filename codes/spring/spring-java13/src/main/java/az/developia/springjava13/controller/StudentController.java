package az.developia.springjava13.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Person;
import az.developia.springjava13.exception.OurRuntimeException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
	
	
	@GetMapping
	public ArrayList<String> student() {
		ArrayList<String> students = new ArrayList<>();
		students.add("Kamil");
		students.add("Ilqar");
		students.add("Mehemmed");
		students.add("Subhan");
		
		return students;
				
	}
	
	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Person p ,BindingResult br) {
		if(br.hasErrors()) {
			throw new OurRuntimeException(br);
		}
		System.out.println(p);
	}
	
	
//	@GetMapping
//	public String showStudent(@RequestParam(name = "q", required = false, defaultValue = "") String q) {
//		ArrayList<String> students = new ArrayList<>();
//		students.add("Kamil");
//		students.add("Ilqar");
//		students.add("Mehemmed");
//		students.add("Subhan");
//
//		ArrayList<String> studentsFilter = new ArrayList<>();
//		students.stream().forEach(s -> {
//			if (s.contains(q)) {
//				studentsFilter.add(s);
//			}
//		});
//
//		System.out.println(studentsFilter);
//
//		return "students";
//	}

}
