package com.developia.endproject.translateApp.service;

import java.util.Optional;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.entity.Word;

public interface WordService {

	WordDto addWord(WordDto wordDto);

	Optional<Word> findByEnglishWord(String english);

	Optional<Word> findByAzerbaijanWord(String azerbaijanWord);

}
