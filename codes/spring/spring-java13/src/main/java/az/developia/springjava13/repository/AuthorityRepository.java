package az.developia.springjava13.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import az.developia.springjava13.entity.AuthorityEntity;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {

	@Query(value = "delete from authorities where username=?1",nativeQuery = true)
	@Modifying
	void deleteByUserAuthorities(String username);

}
