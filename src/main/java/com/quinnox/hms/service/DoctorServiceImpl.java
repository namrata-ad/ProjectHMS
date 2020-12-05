package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.DoctorDao;
import com.quinnox.hms.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorDao doctordao;

	@Override
	public boolean addDoctor(Doctor doctor) {
		return doctordao.addDoctor(doctor);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return doctordao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(String doctorEmail) {
		return doctordao.deleteDoctor(doctorEmail);
	}

	@Override
	public Doctor searchDoctor(int doctorId) {
		return doctordao.searchDoctor(doctorId);
	}

	@Override
	public ArrayList<Doctor> getAllDoctor() {
		return doctordao.getAllDoctor();
	}

	@Override
	public boolean updateDoctorRatings(Doctor doctor) {
		return doctordao.updateDoctorRatings(doctor);
	}

}
