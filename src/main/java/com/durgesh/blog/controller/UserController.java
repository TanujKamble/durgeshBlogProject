package com.durgesh.blog.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.blog.payloads.ApiResponse;
import com.durgesh.blog.payloads.UserDto;
import com.durgesh.blog.service.UserServiceI;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	
	//create user
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUserDto = this.userServiceI.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);}
	
	//update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateteUser(@RequestBody UserDto userDto,@PathVariable Integer userId ){
		UserDto updatedUser = this.userServiceI.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userServiceI.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);}
	
	//get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userServiceI.getAllUsers());}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getsingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServiceI.getUserById(userId));}

}
