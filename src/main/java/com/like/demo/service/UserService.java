package com.like.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.demo.model.User;
import com.like.demo.repository.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public List<User> getUserList() {
		return userMapper.getUserList();			
	}
	
	public User getUser(String userId) {
		return userMapper.getUser(userId);
	}
	
	public void registerUser(User user) {		
		userMapper.insertUser(user);				
	}
	
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
	public void deleteUser(User user) {
		userMapper.deleteUser(user);
	}
	
}
