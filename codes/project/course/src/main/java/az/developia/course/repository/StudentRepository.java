package az.developia.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllByTeacher(String user);

}
