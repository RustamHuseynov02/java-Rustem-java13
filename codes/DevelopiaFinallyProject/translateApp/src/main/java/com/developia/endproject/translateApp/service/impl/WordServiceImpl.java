package com.developia.endproject.translateApp.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.entity.Word;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.WordRepo;
import com.developia.endproject.translateApp.service.SecurityService;
import com.developia.endproject.translateApp.service.UserService;
import com.developia.endproject.translateApp.service.WordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

	private final WordRepo repository;
	private final ModelMapper mapper;
	private final SecurityService securityService;
	private final UserService userService;

	@Override
	public WordDto addWord(WordDto wordDto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, null);
		}
		Optional<Word> check = repository.findByEnglishWord(wordDto.getEnglishWord());
		if (check.isPresent()) {
			throw new OurRuntimeException(null, "bele bir melumat bazada var");
		}
		Optional<Word> isPresent = repository.findByAzerbaijanWord(wordDto.getAzerbaijanWord());
		if (isPresent.isPresent()) {
			throw new OurRuntimeException(null, "bele bir melumat bazada var");
		}

		User user = userService.username(securityService.findByUsername());
		String username = user.getUsername();
		Word word = new Word();
		mapper.map(wordDto, word);
		word.setWhoAddedTheWord(username);
		repository.save(word);
		// response
		WordDto dto = new WordDto();
		mapper.map(word, dto);
		return dto;
	}

	@Override
	public Optional<Word> findByEnglishWord(String english) {
		Optional<Word> o = repository.findByEnglishWord(english);
		return o;
	}

	@Override
	public Optional<Word> findByAzerbaijanWord(String azerbaijanWord) {
		Optional<Word> o = repository.findByAzerbaijanWord(azerbaijanWord);
		return o;
	}
}
