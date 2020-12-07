package com.quinnox.hms.dao;

import java.util.ArrayList;

import com.quinnox.hms.dto.Availablity;

public interface AvailablityDao {
	public boolean addAvailability(Availablity availability);

	public boolean updateAvailability(Availablity availability);

	public boolean deleteAvailability(int availabilityId);

	public Availablity searchAvailability(int availabilityId);

	public ArrayList<Availablity> getAllAvailability();

}
