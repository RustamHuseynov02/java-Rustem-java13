package com.developia.endproject.translateApp.service;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.dto.WordResponse;
import com.developia.endproject.translateApp.entity.Word;

public interface WordService {

	WordDto addWord(WordDto wordDto, BindingResult br);

	Optional<Word> findByEnglishWord(String english);

	Optional<Word> findByAzerbaijanWord(String azerbaijanWord);

	WordResponse findAllWordPagination(Integer begin, Integer length);

}
