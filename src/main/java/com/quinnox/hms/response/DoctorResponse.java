package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Doctor;

import lombok.Data;

@Data
public class DoctorResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Doctor> doctor;

}
