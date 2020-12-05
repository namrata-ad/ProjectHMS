package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.UserDao;
import com.quinnox.hms.dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userdao;

	@Override
	public boolean addUser(User user) {
		return userdao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userdao.updateUser(user);
	}

	@Override
	public User loginUser(User user) {
		return userdao.loginUser(user);
	}

	@Override
	public boolean deleteUser(String userEmail) {
		return userdao.deleteUser(userEmail);

	}

	@Override
	public User searchUser(int userId) {
		return userdao.searchUser(userId);
	}

	@Override
	public ArrayList<User> getAllUser() {
		return userdao.getAllUser();

	}

}
