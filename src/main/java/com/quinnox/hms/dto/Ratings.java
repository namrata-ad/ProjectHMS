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

public class Ratings {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int ratingId;

	@Column(name = "patientid")
	private int patientId;

	@Column(name = "doctorid")
	private int doctorId;

	@Column(name = "ratings")
	private String ratings;

	@Column(name = "feedback")
	private String feedback;
}
