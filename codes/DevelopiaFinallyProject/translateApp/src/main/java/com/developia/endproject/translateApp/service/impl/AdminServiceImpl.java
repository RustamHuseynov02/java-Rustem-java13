package com.developia.endproject.translateApp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.dto.AdminDto;
import com.developia.endproject.translateApp.entity.Admin;
import com.developia.endproject.translateApp.entity.Authority;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.repository.AdminRepo;
import com.developia.endproject.translateApp.service.AdminService;
import com.developia.endproject.translateApp.service.AuthorityService;
import com.developia.endproject.translateApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final AdminRepo repository;
	private final UserService userService;
	private final AuthorityService authorityService;
	private final ModelMapper mapper;

	@Override
	public String signUp(AdminDto adminDto) {
		Admin admin = new Admin();
		mapper.map(adminDto, admin);
		repository.save(admin);
		Authority authority = new Authority();
		authority.setAuthority("ROLE_ADMIN");
		authority.setUsername(adminDto.getUsername());
		authorityService.add(authority);
		User user = new User();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = adminDto.getPassword();
		String raw = encoder.encode(pass);
		user.setUsername(adminDto.getUsername());
		user.setPassword(raw);
		userService.add(user);
		return "Hesab yarandi";
	}
}
