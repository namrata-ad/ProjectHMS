package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Contact;

import lombok.Data;

@Data
public class ContactResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Contact> contact;
}
