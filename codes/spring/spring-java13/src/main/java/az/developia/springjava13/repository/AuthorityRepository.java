package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {

}
