package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.DealerEntity;

public interface DealerRepository extends JpaRepository<DealerEntity, Integer>{

}
