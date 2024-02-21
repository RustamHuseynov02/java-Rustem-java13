package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{

	AdminEntity findByUsername(String username);
	
}
