package com.example.springjavatest.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springjavatest.component.Person;

@Controller
public class ControllerStudent {

	@GetMapping(path = "/students")
	public ArrayList<String> student(@RequestParam(name = "ad",required = false,defaultValue = "name not") String ad) {
		ArrayList<String> students = new ArrayList<>();
		students.add("Kamil");
		students.add("Ilqar");
		students.add("Ramil");
		
		
	
		ArrayList<String> studentsFilter = new ArrayList<String>();
		students.stream().forEach(s ->{
			if (s.contains(ad)) {
				studentsFilter.add(s);
			}
			
			
		});
		System.out.println(studentsFilter);
		return students;
		
		
	}
}
