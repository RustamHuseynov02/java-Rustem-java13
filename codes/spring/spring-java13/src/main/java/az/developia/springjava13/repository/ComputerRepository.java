package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
