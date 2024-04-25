package com.developia.endproject.translateApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.dto.WordResponse;
import com.developia.endproject.translateApp.dto.WordResponseList;
import com.developia.endproject.translateApp.dto.WordUpdateDto;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.entity.Word;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.WordRepo;
import com.developia.endproject.translateApp.service.SecurityService;
import com.developia.endproject.translateApp.service.UserService;
import com.developia.endproject.translateApp.service.WordService;

import jakarta.validation.Valid;
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
	public WordResponse findAllWordPagination(Integer begin, Integer length) {
		List<Word> list = repository.findAllWordPagination(begin, length);

		// response
		List<WordResponseList> responseList = new ArrayList<>();
		for (Word word : list) {
			WordResponseList wordResponseList = new WordResponseList();
			// Burada mapper.map ile Word nesnesini WordResponseList'e dönüştür
			mapper.map(word, wordResponseList);
			responseList.add(wordResponseList);
		}

		WordResponse response = new WordResponse();
		response.setWordList(responseList);
		return response;
	}

	@Override
	public WordUpdateDto updateWord(@Valid WordUpdateDto wordUpdateDto, BindingResult br) {
		if (wordUpdateDto.getId() == null || wordUpdateDto.getId() <= 0) {
			throw new OurRuntimeException(null, "id-ni dogru daxil edin");
		}
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, null);
		}
		Optional<Word> isPresent = repository.findByAzerbaijanWord(wordUpdateDto.getAzerbaijanWord());
		if (isPresent.isPresent()) {
			throw new OurRuntimeException(null, "belə bir məlumat bazada var");
		}
		User user = userService.username(securityService.findByUsername());
		String username = user.getUsername();

		Word word = repository.findById(wordUpdateDto.getId())
				.orElseThrow(() -> new OurRuntimeException(null, "belə bir söz tapılmadı"));
		word.setAzerbaijanWord(wordUpdateDto.getAzerbaijanWord());
		if (word.getWhoAddedTheWord() == username) {
			repository.save(word);
		} else {
			throw new OurRuntimeException(null, "bu sözü redaktə edə bilməzsəm");
		}
		// response
		WordUpdateDto updateDto = new WordUpdateDto();
		updateDto.setAzerbaijanWord(word.getAzerbaijanWord());
		return updateDto;
	}

	@Override
	public String deleteWord(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id-ni dogru daxil edin");
		}
		User user = userService.username(securityService.findByUsername());
		String username = user.getUsername();

		Word word = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "belə bir söz tapılmadı"));
		if (word.getWhoAddedTheWord() == username) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "bu sözü silə bilməzsəm");
		}

		return "Söz xətasız silindi";
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
