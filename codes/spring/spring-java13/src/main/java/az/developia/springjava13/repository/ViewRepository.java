package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.ViewEntity;

public interface ViewRepository extends JpaRepository<ViewEntity, Integer> {

}
