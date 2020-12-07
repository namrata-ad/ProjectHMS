package com.quinnox.hms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.quinnox.hms.dto.Doctor;

public interface DoctorDao 
{
	public boolean addDoctor(Doctor doctor);

	public boolean updateDoctor(Doctor doctor);

	public boolean deleteDoctor(String doctorEmail);

	public Doctor searchDoctor(int doctorId);

	public ArrayList<Doctor> getAllDoctor();
	
	public boolean updateDoctorRatings(Doctor doctor);
	
}
