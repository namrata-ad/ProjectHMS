package com.quinnox.hms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quinnox.hms.dto.User;
import com.quinnox.hms.response.UserResponse;
import com.quinnox.hms.service.UserService;

public class UserController {
	@Autowired
	UserService userServices;

	@PostMapping(path = "/add-user")
	public UserResponse addUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		if (userServices.addUser(user)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Added Successfully");
		}
		return userResponse;
	}

	@PostMapping(path = "/login-user")
	public UserResponse login(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		User userAccount = userServices.loginUser(user);
		if (userAccount != null) {
			userResponse.setStatusCode(201);
			userResponse.setDescription("Success");
			userResponse.setMessage("User Logged in Successfully");
			userResponse.setUser(Arrays.asList(userAccount));
		}
		return userResponse;
	}

	@GetMapping(path = "/get-all-user")
	public UserResponse getAllUser() {
		UserResponse userResponse = new UserResponse();
		List<User> userList = userServices.getAllUser();
		if (userList.size() != 0) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Found Successfully");
			userResponse.setUser(userList);
			return userResponse;
		}
		return userResponse;
	}

	@PutMapping(path = "/modify-user")
	public UserResponse updateUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		if (userServices.updateUser(user)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Name Modified Successfully");
		}
		return userResponse;
	}

	@DeleteMapping(path = "/delete-user/{userEmail}")
	public UserResponse deleteUser(@PathVariable("userEmail") String userEmail) {
		UserResponse userResponse = new UserResponse();
		if (userServices.deleteUser(userEmail)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Deleted Successfully");
		}
		return userResponse;
	}

	@GetMapping(path = "/search-user/{userId}")
	public UserResponse searchUser(@PathVariable("userId") int userId) {
		UserResponse userResponse = new UserResponse();
		User user = userServices.searchUser(userId);
		if (user != null) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Found Successfully");
			userResponse.setUser(Arrays.asList(user));
		}
		return userResponse;
	}

}
