package com.quinnox.hms.service;

import java.util.ArrayList;

import com.quinnox.hms.dto.User;

public interface UserService {
	public boolean addUser(User user);

	public boolean updateUser(User user);

	public User loginUser(User user);

	public boolean deleteUser(String userEmail);

	public User searchUser(int userId);

	public ArrayList<User> getAllUser();

}
