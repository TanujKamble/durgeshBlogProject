package com.durgesh.blog.payloads;

import java.util.Date;

import com.durgesh.blog.entity.Category;
import com.durgesh.blog.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	
	private Integer postId;
	private String title;
	private String content;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;


}
