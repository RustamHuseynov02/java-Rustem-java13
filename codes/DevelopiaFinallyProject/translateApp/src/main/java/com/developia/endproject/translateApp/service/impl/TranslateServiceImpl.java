package com.developia.endproject.translateApp.service.impl;

import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.dto.CommentResponse;
import com.developia.endproject.translateApp.dto.TranslateDto;
import com.developia.endproject.translateApp.dto.TranslateResponse;
import com.developia.endproject.translateApp.entity.Translate;
import com.developia.endproject.translateApp.entity.Word;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.TranslateRepo;
import com.developia.endproject.translateApp.service.TranslateService;
import com.developia.endproject.translateApp.service.WordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService {

	private final TranslateRepo repository;
	private final WordService wordService;

	@Override
	public String translate(TranslateDto translateDto) {
		String english = translateDto.getEnglishWord();
		Word word = wordService.findByEnglishWord(english)
				.orElseThrow(() -> new OurRuntimeException(null, "not found"));
		// response
		TranslateResponse response = new TranslateResponse();
		response.setAzerbaijanWord(word.getAzerbaijanWord());
		return response.getAzerbaijanWord();
	}

	@Override
	public CommentResponse comment(TranslateDto translateDto) {
		Translate translate = new Translate();
		String azerbaijanWord = translateDto.getAzerbaijanWord();
		Word word = wordService.findByAzerbaijanWord(azerbaijanWord)
				.orElseThrow(() -> new OurRuntimeException(null, "not found"));
		word.setUserComment(translateDto.getComment());
		translate.setComment(translateDto.getComment());
		repository.save(translate);
		// response
		CommentResponse response = new CommentResponse();
		response.setComment(translate.getComment());
		response.setAzerbaijanWord(word.getAzerbaijanWord());
		return response;
	}

}
