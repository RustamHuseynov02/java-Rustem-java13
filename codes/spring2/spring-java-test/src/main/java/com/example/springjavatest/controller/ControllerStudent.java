package com.example.springjavatest.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjavatest.component.Student;
import com.example.springjavatest.exception.OurRuntimeException;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/students")
public class ControllerStudent {

	@GetMapping(path = "/students")
	public Student students(Model model) {
		Student student = new Student(1, "Rustem", "Huseynov");
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());
		model.addAttribute("surname", student.getSurname());
		return student;
	}
	
	@PostMapping(path = "/add")
	//1.gonderilen datanin dogrulugunu ve ya baza daxil olacaq melumatin sizin sertlerivize uygun olmasi yoxlamaq 
	//@Valid annotasiyasi ile olacaq
	//2.wep browserden gelen json formatinda datani jackson obyektlere cevirir.biz o obyektleri bazaya gondereceyik
	//jackson hemin obyektleri dataya cevirir bazaya atir ve yerli yerine oturur
	public void addStudent(@Valid @RequestBody Student s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br);
		}
		System.out.println(s);
		
	}
	
	

		
}
