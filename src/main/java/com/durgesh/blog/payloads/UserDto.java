package com.durgesh.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min =4,message= "username must be pf min 4 characters")
	private String name;
	@Email(message= "email address not valid")
	private String email;
	@NotEmpty
	@Size(min = 3, max =10, message= "Password must be of min 3 characters and max 10 characters")
	private String password;
	@NotNull
	private String about;

}
