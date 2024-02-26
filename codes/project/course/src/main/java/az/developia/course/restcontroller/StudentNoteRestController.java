package az.developia.course.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.entity.StudentNote;
import az.developia.course.repository.StudentNoteRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "student-note")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentNoteRestController {

	private final StudentNoteRepository repository;
	
	@PostMapping
	public StudentNote saveNot(@RequestBody StudentNote not) {
		return repository.save(not);
	}
	
	@GetMapping(path = "/{studentId}")
	public List<StudentNote> getNot(@PathVariable Integer studentId) {
		return repository.findAllByStudentId(studentId);
	}
	
}
