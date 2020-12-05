package com.quinnox.hms.service;

import java.util.ArrayList;

import com.quinnox.hms.dto.Ratings;

public interface RatingService {
	public boolean addRatings(Ratings ratings);

	public boolean updateRatings(Ratings ratings);

	public boolean deleteRatings(int ratingId);

	public RatingService searchRatings(int ratingId);

	public ArrayList<Ratings> getAllRatings();

}
