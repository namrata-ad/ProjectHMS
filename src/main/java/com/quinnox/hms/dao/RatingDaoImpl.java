package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Contact;
import com.quinnox.hms.dto.Patient;
import com.quinnox.hms.dto.Ratings;
import com.quinnox.hms.exception.HospitalException;
@Repository
public class RatingDaoImpl implements RatingDao {
@Autowired
EntityManager manager;
	@Override
	@Transactional
	public boolean addRatings(Ratings ratings) {
		manager.merge(ratings);
		return true;
	}

	@Override
	public boolean updateRatings(Ratings ratings) {
		//String jpql="update ratings "
		return false;
	}

	@Override
	public boolean deleteRatings(int ratingId) {
		String jpql = "delete from ratings where ratingId=: rid";
		Query query = manager.createQuery(jpql);
		query.setParameter("rid", ratingId);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
		
	}

	@Override
	public RatingDao searchRatings(int ratingId) {
		Ratings ratings1;
		ratings1 = manager.find(Ratings.class, ratingId);
		if (ratings1 != null) {
			//return ratings1;
		}
		
		return null;
	}

	@Override
	public ArrayList<Ratings> getAllRatings() {
		String jpql = " from ratings";
		Query query = manager.createQuery(jpql, Ratings.class);
		ArrayList<Ratings> ratingsList = (ArrayList<Ratings>) query.getResultList();
		if (ratingsList != null && ratingsList.size() != 0) {
			return ratingsList;
		}
		return null;
	}

}
