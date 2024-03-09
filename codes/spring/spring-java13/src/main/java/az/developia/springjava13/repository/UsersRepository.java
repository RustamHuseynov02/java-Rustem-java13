package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users username(String a);

}
