package com.durgesh.blog.service;

import java.util.List;

import com.durgesh.blog.payloads.UserDto;

public interface UserServiceI {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);


}
