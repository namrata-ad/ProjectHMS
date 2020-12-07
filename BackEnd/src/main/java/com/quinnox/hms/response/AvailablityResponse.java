package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Availablity;

import lombok.Data;

@Data
public class AvailablityResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Availablity> availablity;
}
