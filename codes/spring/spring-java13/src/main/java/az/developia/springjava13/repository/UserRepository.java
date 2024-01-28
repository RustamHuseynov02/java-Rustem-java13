package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
