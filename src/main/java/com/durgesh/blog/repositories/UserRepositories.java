package com.durgesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.blog.entity.User;

public interface UserRepositories extends JpaRepository<User, Integer> {

}
