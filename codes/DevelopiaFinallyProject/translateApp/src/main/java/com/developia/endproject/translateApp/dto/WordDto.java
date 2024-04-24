package com.developia.endproject.translateApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WordDto {

	@NotEmpty
	private String azerbaijanWord;
	@NotEmpty
	private String englishWord;
}
