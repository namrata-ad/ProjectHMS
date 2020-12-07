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


import com.quinnox.hms.dao.RatingDao;

import com.quinnox.hms.dto.Ratings;

import com.quinnox.hms.response.RatingsResponse;

public class RatingsController {
	@Autowired
	RatingDao ratingServices;
	@PostMapping(path="/add-ratings")
	public RatingsResponse addRating(@RequestBody Ratings ratings) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		if (ratingServices.addRatings(ratings) ){
			ratingsResponse.setStatusCode(201);;
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Added Successfully");
		}
		else {
			ratingsResponse.setStatusCode(401);
			ratingsResponse.setMessage("error");
			ratingsResponse.setDescription("Something went wrong");
		}
		return ratingsResponse;
		
	}
	@GetMapping(path = "/get-all-ratings")
	public RatingsResponse getAllRatings() {
		RatingsResponse ratingsResponse = new RatingsResponse();
		List<Ratings> ratingsList = ratingServices.getAllRatings();
		if (ratingsList.size() != 0) {
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Found Successfully");
			ratingsResponse.setRatings(ratingsList);
			
		}
		return ratingsResponse;
	}
	@PutMapping(path = "/modify-rating")
	public RatingsResponse updateRatings(@RequestBody Ratings rating) {
		RatingsResponse RatingsResponse = new RatingsResponse();
		if (ratingServices.updateRatings(rating)) {
			RatingsResponse.setStatusCode(201);
			RatingsResponse.setMessage("Success");
			RatingsResponse.setDescription("Ratings Modified Successfully");
		}
		return RatingsResponse;
	}

	@DeleteMapping(path = "/delete-rating/{RatingsID1}")
	public RatingsResponse deleteRatings(@PathVariable("RatingsID1") int RatingsID1) 
	{
		RatingsResponse ratingsResponse = new RatingsResponse();
		if (ratingServices.deleteRatings(RatingsID1))
		{
			ratingsResponse.setStatusCode(201);
			ratingsResponse.setMessage("Success");
			ratingsResponse.setDescription("Ratings Deleted Successfully");
		}
		return ratingsResponse;}
	

//	@GetMapping(path = "/search-rating/{ratingId}")
//	public RatingsResponse searchresponse(@PathVariable("ratingId") int ratingId) {
//		RatingsResponse ratingsResponse = new RatingsResponse();
//		Ratings ratings = ratingServices.searchRatings(ratingId);
//		if (ratings != null) {
//			ratingsResponse.setStatusCode(201);
//			ratingsResponse.setMessage("Success");
//			ratingsResponse.setDescription("Ratings Found Successfully");
//			ratingsResponse.(Arrays.asList(ratings));
//		}
//		return ratingsResponse;
//	}
}
