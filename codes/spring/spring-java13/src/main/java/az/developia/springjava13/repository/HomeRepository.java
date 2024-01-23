package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {

}
