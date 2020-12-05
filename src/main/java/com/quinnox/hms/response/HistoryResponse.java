package com.quinnox.hms.response;

import java.util.List;

import com.quinnox.hms.dto.History;

import lombok.Data;

@Data
public class HistoryResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<History> history;
}
