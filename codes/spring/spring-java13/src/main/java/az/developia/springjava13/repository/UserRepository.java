package az.developia.springjava13.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava13.entity.UserEntity;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query(value = "UPDATE users SET username=?1 where username=?2",nativeQuery = true)
	@Modifying
	void saveByUser(String username,String newUsername);



	

}
