package com.developia.endproject.translateApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.Word;

public interface WordRepo extends JpaRepository<Word, Integer> {

	Optional<Word> findByEnglishWord(String englishWord);

	Optional<Word> findByAzerbaijanWord(String azerbaijanWord);

}
