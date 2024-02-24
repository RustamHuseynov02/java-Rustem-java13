package az.developia.springjava13.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecutiryService {

	public String findByUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}
}
