package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.RatingDao;
import com.quinnox.hms.dto.Ratings;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	RatingDao ratingdao;

	@Override
	public boolean addRatings(Ratings ratings) {
		return ratingdao.addRatings(ratings);
	}

	@Override
	public boolean updateRatings(Ratings ratings) {
		return updateRatings(ratings);
	}

	@Override
	public boolean deleteRatings(int ratingId) {
		return deleteRatings(ratingId);
	}

	@Override
	public RatingService searchRatings(int ratingId) {
		return searchRatings(ratingId);
	}

	@Override
	public ArrayList<Ratings> getAllRatings() {
		return getAllRatings();

	}

}
