package com.quinnox.hms.service;

import java.util.ArrayList;

import com.quinnox.hms.dto.Contact;

public interface ContactService {
	public boolean addContact(Contact contact);

	public boolean deleteContact(int contactId);

	public ArrayList<Contact> getAllContact();
}
