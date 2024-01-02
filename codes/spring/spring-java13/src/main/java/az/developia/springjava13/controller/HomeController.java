package az.developia.springjava13.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	
     @GetMapping
     public String showHome() {
    	 return "Home";
     }
     
     @GetMapping(path = "/student")
     public String showStudent(@RequestParam(name = "q") String q) {
    	 ArrayList<String> students = new ArrayList<>();
    	 students.add("Kamil");
    	 students.add("Ilqar");
    	 students.add("Mehemmed");
    	 students.add("Subhan");
    	 
    	 ArrayList<String> studentsFilter = new ArrayList<>();
    	 students.stream().forEach(s->{
    		if (s.contains(q)) {
				studentsFilter.add(s);
			} 
    	 });
    	 
    	 System.out.println(studentsFilter);
    	 
    	 
    	 return "students";
     }
     
     @GetMapping(path = "/book")
     public String showBook() {
    	 return "book";
     }
     
     @GetMapping(path = "/computers")
     public String showComputer() {
    	 return "computer";
     }
     
}
