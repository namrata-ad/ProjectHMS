package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Doctor;
import com.quinnox.hms.dto.User;
import com.quinnox.hms.exception.HospitalException;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addUser(User user) {
		manager.merge(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		String jpql = "update user set username=uname, useremail=uemail userpassword=upassword, userrole=urole "
				+ "where userId = : uid";
		Query query = manager.createQuery(jpql);
		query.setParameter("uname", user.getUserName());
		query.setParameter("uemail", user.getUserEmail());
		query.setParameter("upassword", user.getUserPassword());
		query.setParameter("urole", user.getRole());
		query.setParameter("uid", user.getUserId());
		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public User loginUser(User user) {

		return null;
	}

	@Override
	public boolean deleteUser(String userEmail) {
		String jpql = "delete from userEmail=: email";
		Query query = manager.createQuery(jpql);
		query.setParameter("email", userEmail);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;

		} else
			return false;
	}

	@Override
	public User searchUser(int userId) {
		User user1;
		user1 = manager.find(User.class, userId);
		if (user1 != null) {
			return user1;
		}
		return null;
	}

	@Override
	public ArrayList<User> getAllUser() {
		String jpql = "from User ";
		Query query = manager.createQuery(jpql, User.class);
		ArrayList<User> userList = (ArrayList<User>) query.getResultList();
		if (userList != null && userList.size() != 0) {
			return userList;
		}
		return null;
	}

}
