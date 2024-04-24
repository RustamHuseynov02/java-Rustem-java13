package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.service.WordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "word")
@RequiredArgsConstructor
public class WordRest {

	private final WordService service;

	@PostMapping(path = "/add")
	public ResponseEntity<Object> addWord(@Valid @RequestBody WordDto wordDto, BindingResult br) {
		return new ResponseEntity<Object>(service.addWord(wordDto, br), HttpStatus.OK);
	}
}
