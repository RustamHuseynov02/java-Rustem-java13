package com.developia.endproject.translateApp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.dto.UserDto;
import com.developia.endproject.translateApp.entity.Authority;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.repository.UserRepo;
import com.developia.endproject.translateApp.service.AuthorityService;
import com.developia.endproject.translateApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepo repository;
	private final AuthorityService authorityService;
	private final ModelMapper mapper;

	// logic codes
	@Override
	public String signUp(UserDto userDto) {
		User user = new User();
		mapper.map(userDto, user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = userDto.getPassword();
		String raw = passwordEncoder.encode(pass);
		user.setPassword(raw);
		user.setEnabled(1);
		repository.save(user);
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUsername(userDto.getUsername());
		authorityService.add(authority);
		return "Hesab yarandi";
	}

	@Override
	public void add(User user) {
		repository.save(user);

	}

}
