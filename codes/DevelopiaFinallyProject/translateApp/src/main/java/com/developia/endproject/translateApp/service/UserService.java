package com.developia.endproject.translateApp.service;

import com.developia.endproject.translateApp.dto.UserDto;
import com.developia.endproject.translateApp.entity.User;

public interface UserService {

	String signUp(UserDto userDto);

	void add(User user);

}
