package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Appointment;

import lombok.Data;

@Data
public class AppointmentResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Appointment> appointment;
}
