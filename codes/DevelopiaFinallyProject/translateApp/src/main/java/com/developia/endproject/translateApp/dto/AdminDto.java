package com.developia.endproject.translateApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private Integer id;
	private String name;
	private String surname;
	private String username;
	private String password;
}
