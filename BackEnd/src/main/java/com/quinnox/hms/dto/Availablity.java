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
public class Availablity {
	@Id
	@GeneratedValue
	@Column(name = "availabilityid")
	private int availabilityId;

	@Column(name = "doctorid")
	private int doctorId;

	@Column(name = "fromdate")
	private String fromDate;

	@Column(name = "todate")
	private String toDate;

	@Column
	private String availability;

}
