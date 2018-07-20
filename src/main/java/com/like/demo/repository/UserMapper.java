package com.like.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.like.demo.model.User;

@Mapper
public interface UserMapper {

	User getUser(String userId);
	
	List<User> getUserList();
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);		
}
