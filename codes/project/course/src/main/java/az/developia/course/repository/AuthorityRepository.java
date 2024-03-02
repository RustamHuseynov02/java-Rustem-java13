package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

}
