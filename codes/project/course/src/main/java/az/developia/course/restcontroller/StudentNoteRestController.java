package az.developia.course.restcontroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.StudentNote;
import az.developia.course.service.StudentNoteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "student-note")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentNoteRestController {

	private final StudentNoteService service;
	
	@PostMapping
	public ResponseEntity<Object> saveNot(@RequestBody StudentNote not) {
		ResponseEntity<Object> resp = service.addNot(not);
		return resp;
	}
	
	@GetMapping(path = "/{studentId}")
	public ResponseEntity<Object> getNot(@PathVariable Integer studentId) {
		ResponseEntity<Object> resp = service.findAllByStudentId(studentId);
		return resp;
	}
	
}
