package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.ContactDao;
import com.quinnox.hms.dto.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactDao contactdao;

	@Override
	public boolean addContact(Contact contact) {
		return contactdao.addContact(contact);
	}

	@Override
	public boolean deleteContact(int contactId) {
		return contactdao.deleteContact(contactId);
	}

	@Override
	public ArrayList<Contact> getAllContact() {
		return contactdao.getAllContact();
	}

}
