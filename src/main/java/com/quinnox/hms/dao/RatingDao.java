package com.quinnox.hms.dao;

import java.util.ArrayList;

import com.quinnox.hms.dto.Ratings;

public interface RatingDao {
	public boolean addRatings(Ratings ratings);

	public boolean updateRatings(Ratings ratings);

	public boolean deleteRatings(int ratingId);

	public RatingDao searchRatings(int ratingId);

	public ArrayList<Ratings> getAllRatings();

}
