package com.quinnox.hms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quinnox.hms.dao.DoctorDao;
import com.quinnox.hms.dto.Doctor;
import com.quinnox.hms.dto.History;
import com.quinnox.hms.response.DoctorResponse;
import com.quinnox.hms.response.HistoryResponse;

public class HistoryController {
	@Autowired
	HistoryController historyServices;
	
	@PostMapping(path="/add-history")
	public HistoryResponse addHistory(@RequestBody History history) {
		HistoryResponse historyResponse = new HistoryResponse();
		if (historyServices.addHistory(history) != null) {
			historyResponse.setStatusCode(201);
			historyResponse.setMessage("Success");
			historyResponse.setDescription("History Added Successfully");
		}
		else {
			historyResponse.setStatusCode(401);
			historyResponse.setMessage("error");
			historyResponse.setDescription("Something went wrong");
		}
		return historyResponse;
	}
//	@GetMapping(path = "/get-all-history")
//	public HistoryResponse getAllHistory() {
//		HistoryResponse historyResponse = new HistoryResponse();
//		List<History> historyList = historyServices.getAllHistory();
//		if (historyList.size() != 0) {
//			historyResponse.setStatusCode(201);
//			historyResponse.setMessage("Success");
//			historyResponse.setDescription("History Found Successfully");
//			historyResponse.setHistory(historyList);
//			return historyResponse;
//		}
//		return historyResponse;
//	}
	
	@DeleteMapping(path = "/delete-history/{historyId}")
	public HistoryResponse deleteHistory(@PathVariable("historyId") int historyId) {
		HistoryResponse historyResponse = new HistoryResponse();
		if (historyServices.deleteHistory(historyId) != null) {
			historyResponse.setStatusCode(201);
			historyResponse.setMessage("Success");
			historyResponse.setDescription("History Deleted Successfully");
		}
		return historyResponse;
}
}