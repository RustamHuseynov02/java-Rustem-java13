package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
