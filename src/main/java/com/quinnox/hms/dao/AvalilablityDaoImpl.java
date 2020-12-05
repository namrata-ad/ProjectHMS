package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Availablity;
import com.quinnox.hms.exception.HospitalException;
@Repository
public class AvalilablityDaoImpl implements AvailablityDao {
@Autowired
EntityManager manager;
	@Override
	@Transactional
	public boolean addAvailability(Availablity availability) {
		manager.merge(availability);
		return true;
	}

	@Override
	public boolean updateAvailability(Availablity availability) {
		String jpql = "update Avaiablity set availablityDatte=:adate, availablity=:atime, "
				+ "availablityStatus=:sts where availablityId = : aid";
		Query query = manager.createQuery(jpql);
		query.setParameter("a_date", availability.getFromDate());
		query.setParameter("a_time", availability.getToDate());
		query.setParameter("s_ts", availability.getAvailability());
		query.setParameter("a_id", availability.getAvailabilityId());

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public boolean deleteAvailability(int availabilityId) {
		String jpql = "delete from Availablity where availablityId = : aid ";
		Query query = manager.createQuery(jpql);
		query.setParameter("a_id", availabilityId);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public Availablity searchAvailability(int availabilityId) {
		Availablity availability1;
		availability1 = manager.find(Availablity.class, availabilityId);
		return availability1;
	}

	@Override
	public ArrayList<Availablity> getAllAvailability() {
		String jpql = "from availability ";
		Query query = manager.createQuery(jpql, Appointment.class);
		ArrayList<Availablity> availabilityList = (ArrayList<Availablity>) query.getResultList();
		if (availabilityList != null && availabilityList.size() != 0) {
			
		}
		
		int i = 0;
		if (i > 0) {
			return availabilityList;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

}
