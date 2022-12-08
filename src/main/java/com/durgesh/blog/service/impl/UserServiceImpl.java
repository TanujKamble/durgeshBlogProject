package com.durgesh.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.blog.entity.User;
import com.durgesh.blog.exceptions.ResourceNotFoundException;
import com.durgesh.blog.payloads.UserDto;
import com.durgesh.blog.repositories.UserRepositories;
import com.durgesh.blog.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	public UserRepositories userRepositories;

	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * @author dell tanuj kamble
	 */
	@Override
	public UserDto createUser(UserDto userDto) {
	User user = this.dtoToUser(userDto);
	User savedUser = this.userRepositories.save(user);
		return this.userToDto(savedUser);
	}

	/**
	 * @apiNote this method is used to update user
	 *@exception 
	 */
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepositories.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepositories.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}
	
	/**
	 * @return user
	 */
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepositories.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepositories.findAll();
		List<UserDto> userDtos = users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	/**
	 * @
	 */
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepositories.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepositories.delete(user);
	}
	
	
	public User dtoToUser(UserDto userDto) {
		
		User user= this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
	UserDto userDto=this.modelMapper.map(user, UserDto.class);
//	userDto.setId(user.getId());
//	userDto.setName(user.getName());
//	userDto.setEmail(user.getEmail());
//	userDto.setPassword(user.getPassword());
//	userDto.setAbout(user.getAbout());
	
	return userDto;
	}



}
