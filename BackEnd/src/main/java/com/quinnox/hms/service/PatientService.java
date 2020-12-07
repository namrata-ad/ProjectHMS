package com.quinnox.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.quinnox.hms.dto.Patient;

public interface PatientService {
	public boolean addPatient(Patient patient);

	public boolean updatePatient(Patient patient);

	public boolean deletePatient(String patientEmail);

	public Patient searchPatient(int patientId);

	public ArrayList<Patient> getAllPatient();
}
