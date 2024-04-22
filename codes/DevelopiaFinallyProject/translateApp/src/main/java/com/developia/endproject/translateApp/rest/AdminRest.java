package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.AdminDto;
import com.developia.endproject.translateApp.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
public class AdminRest {

	private final AdminService service;

	@PostMapping(path = "/signup")
	@PreAuthorize(value = "hasAuthority('ROLE_NEXT_ADMIN')")
	public ResponseEntity<String> singUp(@RequestBody AdminDto adminDto) {
		return new ResponseEntity<String>(service.signUp(adminDto), HttpStatus.CREATED);
	}
}
