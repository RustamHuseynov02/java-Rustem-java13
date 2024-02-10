package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.OwnerEntity;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer>{

	OwnerEntity findByUsername(String username);

}
