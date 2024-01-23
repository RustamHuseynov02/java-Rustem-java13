package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
