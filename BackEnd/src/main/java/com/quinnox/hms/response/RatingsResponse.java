package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.Ratings;

import lombok.Data;
@Data
public class RatingsResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Ratings> ratings;
}
