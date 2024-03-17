package az.developia.springjava13.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.entity.AdminEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AdminRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/admins")
@RequiredArgsConstructor
public class AdminController {

	private final AdminRepository repository;
	
	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "PreAuthority('ROLE_DELETE_ADMIN')")
	public void delete(@PathVariable Integer id) {
		if (id==null|| id<=0) {
			throw new OurRuntimeException(null, "id-ni dogru daxil edin");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AdminEntity entity = repository.findByUsername(username);
		if (entity==null) {
			throw new OurRuntimeException(null, "bele biri tapilmadi");
		}
		Integer adminId = entity.getId();
		
		AdminEntity en = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "bele bir id yoxdur"));
		
		if (adminId == en.getId()) {
			repository.deleteById(id);
		}
		else {
			throw new OurRuntimeException(null, "bu admini sile bilmezsen");
		}
		
		
	}
	
}
