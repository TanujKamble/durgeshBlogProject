package com.durgesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
