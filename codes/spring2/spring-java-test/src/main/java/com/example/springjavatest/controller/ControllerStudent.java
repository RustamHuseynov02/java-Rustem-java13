package com.example.springjavatest.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springjavatest.component.Person;
import com.example.springjavatest.component.Student;

@Controller
public class ControllerStudent {

	@GetMapping(path = "/students")
	public Student students(Model model) {
		Student student = new Student(1, "Rustem", "Huseynov");
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());
		model.addAttribute("surname", student.getSurname());
		return student;
	}
//	public ArrayList<String> student(@RequestParam(name = "ad",required = false,defaultValue = "name not") String ad,Model model) {
//		ArrayList<String> student = new ArrayList<>();
//		student.add("Kamil");
//		student.add("Ilqar");
//		student.add("Ramil");
//		
//		
//		
//	
//		ArrayList<String> studentsFilter = new ArrayList<String>();
//		student.stream().forEach(s ->{
//			if (s.contains(ad)) {
//				studentsFilter.add(s);
//			}
//			
//			
//		});
//		model.addAttribute("ad", studentsFilter);
//		System.out.println(studentsFilter);
//		return student;
		
		
}
