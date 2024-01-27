package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
