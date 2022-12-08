package com.durgesh.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.durgesh.blog.entity.Category;

@SpringBootApplication
public class BlogggingApp2Application {


	public static void main(String[] args) {
		

		
		SpringApplication.run(BlogggingApp2Application.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	


}
