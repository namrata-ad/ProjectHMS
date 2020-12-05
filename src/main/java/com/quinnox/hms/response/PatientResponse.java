package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Patient;

import lombok.Data;

@Data
public class PatientResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Patient> patient;
}
