package az.developia.springjava13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	List<StudentEntity> findAllByTeacherId(Integer teacherId);


	

}
