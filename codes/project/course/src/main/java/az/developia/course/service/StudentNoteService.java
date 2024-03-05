package az.developia.course.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import az.developia.course.entity.StudentNote;
import az.developia.course.repository.StudentNoteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentNoteService {

	private final StudentNoteRepository repository;

	public ResponseEntity<Object> findAllByStudentId(Integer id) {
		List<StudentNote> s = repository.findAllByStudentId(id);
		return ResponseEntity.ok(s);
	}

	public void deleteAll(List<StudentNote> d) {
		 repository.deleteAll(d); 
		
	}

	public ResponseEntity<Object> addNot(StudentNote not) {
		  StudentNote s = repository.save(not);
		return ResponseEntity.ok(s);
	}

	public List<StudentNote> findAllByStudentListId(Integer id) {
		List<StudentNote> s = repository.findAllByStudentId(id);
		return s;
	}
	
	
}
