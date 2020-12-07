package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Contact;
import com.quinnox.hms.exception.HospitalException;

@Repository
public class ContactDaoImpl implements ContactDao {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addContact(Contact contact) {
		manager.merge(contact);
		return true;
	}

	@Override
	public boolean deleteContact(int contactId) {
		String jpql = "delete from contact where contactid=: cid";
		Query query = manager.createQuery(jpql);
		query.setParameter("aid", contactId);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public ArrayList<Contact> getAllContact() {
		String jpql = " from contact";
		Query query = manager.createQuery(jpql, Appointment.class);
		ArrayList<Contact> contactList = (ArrayList<Contact>) query.getResultList();
		if (contactList != null && contactList.size() != 0) {
			return contactList;
		}
		return null;
	}

}
