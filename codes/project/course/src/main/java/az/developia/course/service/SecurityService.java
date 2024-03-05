package az.developia.course.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {

	
	public String getUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}
	
}
