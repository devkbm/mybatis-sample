package com.like.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.demo.model.User;
import com.like.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUserList() {
					
		List<User> userList = service.getUserList();
		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value="id") String id) {
					
		User user = service.getUser(id); 
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user/{id}")
	public ResponseEntity<String> registerUser(
			@PathVariable(value="id") String id,
			@Valid @RequestBody User user, 
			BindingResult result) {
		
		if ( result.hasErrors()) {
			throw new IllegalArgumentException(result.getFieldErrors().toString());
		} 
		
		service.registerUser(user);
		
		return new ResponseEntity<String>(user.getUserId() + "가 등록되었습니다.", HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(
			@PathVariable(value="id") String id,
			@Valid @RequestBody User user, 
			BindingResult result) {
		
		if ( result.hasErrors()) {
			throw new IllegalArgumentException(result.getFieldErrors().toString());
		}
		
		service.updateUser(user);
		
		return new ResponseEntity<String>(user.getUserId() + "가 수정되었습니다.", HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value="id") String id) {
		
		User user = service.getUser(id);
		
		service.deleteUser(user); 
		
		return new ResponseEntity<String>(user.getUserId() + "가 삭제되었습니다.", HttpStatus.OK);
	}
		
	
}
