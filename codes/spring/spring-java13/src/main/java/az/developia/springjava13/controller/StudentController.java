package az.developia.springjava13.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
