package com.developia.endproject.translateApp.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.entity.Word;
import com.developia.endproject.translateApp.repository.WordRepo;
import com.developia.endproject.translateApp.service.WordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

	private final WordRepo repository;
	private final ModelMapper mapper;

	@Override
	public WordDto addWord(WordDto wordDto) {
		System.out.println(wordDto);
		Word word = new Word();
		mapper.map(wordDto, word);
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
