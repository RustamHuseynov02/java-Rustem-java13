package az.developia.springjava13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava13.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	List<StudentEntity> findAllByCreator(Integer creator);

	@Query(value = "select * from students limit ?1,?2", nativeQuery = true)
	List<StudentEntity> findPagination(Integer b,Integer l);


	

}
