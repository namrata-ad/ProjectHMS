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

public class Patient {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int patientId;

	@Column(name = "firstname")
	private String patientFirstName;

	@Column(name = "lastname")
	private String patientLastName;

	@Column(name = "email")
	private String patientEmail;

	@Column(name = "phoneNo")
	private long phoneNo;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "health_issue")
	private String healthIssue;
}
