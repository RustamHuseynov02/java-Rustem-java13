package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.Person;

public interface StudentRepository extends JpaRepository<Person, Integer>{

}
