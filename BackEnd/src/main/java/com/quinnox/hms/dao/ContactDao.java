package com.quinnox.hms.dao;

import java.util.ArrayList;

import com.quinnox.hms.dto.Contact;

public interface ContactDao {
	public boolean addContact(Contact contact);

	public boolean deleteContact(int contactId);

	public ArrayList<Contact> getAllContact();
}
