package com.quinnox.hms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quinnox.hms.dao.AvailablityDao;

import com.quinnox.hms.dto.Availablity;

import com.quinnox.hms.response.AvailablityResponse;

public class AvailablityController {
	@Autowired
	AvailablityDao availablityServices;
	@PostMapping(path="/add-availablity")
	public AvailablityResponse addAvailablity(@RequestBody Availablity availablity ) {
		AvailablityResponse availablityResponse = new AvailablityResponse();
		if (availablityServices.addAvailability(availablity)) {
			availablityResponse.setStatusCode(201);
			availablityResponse.setMessage("Success");;
			availablityResponse.setDescription("Availablity Added Successfully");
		}
		else {
			availablityResponse.setStatusCode(401);
			availablityResponse.setMessage("error");
			availablityResponse.setDescription("Something went wrong");
		}
		return availablityResponse;
		
	}
	@GetMapping(path = "/get-all-availablity")
	public AvailablityResponse getAllAvailablity() {
		AvailablityResponse availablityResponse = new AvailablityResponse();
		List<Availablity> availablityList = availablityServices.getAllAvailability();
		if (availablityList.size() != 0) {
			
			availablityResponse.setStatusCode(201);;
			availablityResponse.setDescription("Availablity found successfully");;
			availablityResponse.setMessage("Success");;
			return availablityResponse;
		}
		return availablityResponse;
	}
	@PutMapping(path = "/modify-avaliblity")
	public AvailablityResponse updateResponse(@RequestBody Availablity availablity) {
		AvailablityResponse availablityResponse = new AvailablityResponse();
		if (availablityServices.updateAvailability(availablity)) {
			availablityResponse.setStatusCode(201);
			availablityResponse.setMessage("Success");
			availablityResponse.setDescription("Availablity Modified Successfully");
		}
		return availablityResponse;
	}

	@DeleteMapping(path = "/delete-availablity/{availablityId}")
	public AvailablityResponse deleteAvailablity(@PathVariable("availablityId") int availablityId) {
		AvailablityResponse availablityResponse = new AvailablityResponse();
		if (availablityServices.deleteAvailability(availablityId)) {
			availablityResponse.setStatusCode(201);
			availablityResponse.setMessage("Success");
			availablityResponse.setDescription("Availablity Deleted Successfully");
		}
		return availablityResponse;
	}

	@GetMapping(path = "/search-availablity/{availablityId}")
	public AvailablityResponse searchAvailablity(@PathVariable("availablityId") int availablityId) {
		AvailablityResponse availablityResponse = new AvailablityResponse();
		Availablity availablity = availablityServices.searchAvailability(availablityId);
		if (availablity != null) {
			availablityResponse.setStatusCode(201);
			availablityResponse.setMessage("Success");
			availablityResponse.setDescription("Doctor Found Successfully");
			//availablityResponse.setAvailablity(availablity););
		}
		return availablityResponse;
	}
	
}


