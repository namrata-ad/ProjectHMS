package com.quinnox.hms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Doctor 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int doctorId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String doctorEmail;

	@Column
	private String ratings;

	@Column
	private String specialization;

	@Column
	private String clinicName;

}
