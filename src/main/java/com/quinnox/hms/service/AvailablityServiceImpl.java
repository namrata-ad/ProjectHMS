package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.AvailablityDao;
import com.quinnox.hms.dto.Availablity;

@Service
public class AvailablityServiceImpl implements AvailablityService {
	@Autowired
	AvailablityDao availablitydao;

	@Override
	public boolean addAvailability(Availablity availability) {
		return availablitydao.addAvailability(availability);
	}

	@Override
	public boolean updateAvailability(Availablity availability) {
		return availablitydao.updateAvailability(availability);
	}

	@Override
	public boolean deleteAvailability(int availabilityId) {
		return availablitydao.deleteAvailability(availabilityId);
	}

	@Override
	public Availablity searchAvailability(int availabilityId) {
		return availablitydao.searchAvailability(availabilityId);
	}

	@Override
	public ArrayList<Availablity> getAllAvailability() {
		return availablitydao.getAllAvailability();
	}

}
