package az.developia.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.entity.StudentNote;

public interface StudentNoteRepository extends JpaRepository<StudentNote, Integer> {

	List<StudentNote> findAllByStudentId(Integer studentId);

}
