package com.quinnox.hms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table

public class Contact {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int contactId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String emailId;

	@Column
	private String comment;

}
