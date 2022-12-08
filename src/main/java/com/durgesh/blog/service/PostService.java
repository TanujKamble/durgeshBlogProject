package com.durgesh.blog.service;

import java.util.List;

import com.durgesh.blog.entity.Post;
import com.durgesh.blog.payloads.PostDto;
import com.durgesh.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	//update
		PostDto updatePost(PostDto postDto, Integer postId);

	//delete
	void deletePost(Integer postId);
	
	//get all Posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single Post
	PostDto getPostById(Integer postId);
	
	//get All post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
}
