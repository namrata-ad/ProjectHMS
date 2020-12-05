package com.quinnox.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.quinnox.hms.dto.Doctor;

public interface DoctorService {
	public boolean addDoctor(Doctor doctor);

	public boolean updateDoctor(Doctor doctor);

	public boolean deleteDoctor(String doctorEmail);

	public Doctor searchDoctor(int doctorId);

	public ArrayList<Doctor> getAllDoctor();

	public boolean updateDoctorRatings(Doctor doctor);

}
