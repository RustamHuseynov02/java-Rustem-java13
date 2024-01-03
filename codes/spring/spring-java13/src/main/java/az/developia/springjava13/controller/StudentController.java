package az.developia.springjava13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping(path = "/students")
	public String student() {
		return "students2";
	}
}
