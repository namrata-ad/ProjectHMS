package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.PatientDao;
import com.quinnox.hms.dto.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientDao patientdao;

	@Override
	public boolean addPatient(Patient patient) {
		return patientdao.addPatient(patient);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		return patientdao.updatePatient(patient);
	}

	@Override
	public boolean deletePatient(String patientEmail) {
		return patientdao.deletePatient(patientEmail);
	}

	@Override
	public Patient searchPatient(int patientId) {
		return patientdao.searchPatient(patientId);
	}

	@Override
	public ArrayList<Patient> getAllPatient() {
		return patientdao.getAllPatient();
	}

}
