package com.quinnox.hms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.quinnox.hms.dao.PatientDao;

import com.quinnox.hms.dto.Patient;
import com.quinnox.hms.response.DoctorResponse;
import com.quinnox.hms.response.PatientResponse;
@RestController
public class PatientController {
	@Autowired
	PatientDao patientServices;
	@PostMapping(path="/add-patient")
	public PatientResponse addPatient(@RequestBody Patient patient) {
		PatientResponse patientResponse = new PatientResponse();
		System.out.println("------"+patient);
		if (patientServices.addPatient(patient)) 
		{
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Added Successfully");
			
		}
		return patientResponse;
		
		
	}
		@GetMapping(path = "/get-all-patient")
		public PatientResponse getAllPatient() {
			PatientResponse patientResponse = new PatientResponse();
			List<Patient> patientList = patientServices.getAllPatient();
			if (patientList.size() != 0) {
				patientResponse.setPatient(patientList);;;
				patientResponse.setMessage("Success");
				patientResponse.setDescription("Doctor Found Successfully");
				patientResponse.setStatusCode(201);
				return patientResponse;
			}
			return patientResponse;
		}
		@PutMapping(path = "/modify-patient")
		public DoctorResponse updateDoctor(@RequestBody Patient patient) {
			DoctorResponse doctorResponse = new DoctorResponse();
			if (patientServices.updatePatient(patient)) {
				doctorResponse.setStatusCode(201);
				doctorResponse.setMessage("Success");
				doctorResponse.setDescription("Doctor Modified Successfully");
			}
			return doctorResponse;
		}

		@DeleteMapping(path = "/delete-doctor/{patientEmail}")
		public PatientResponse deletePatient(@PathVariable("patientEmail") String patientEmail) {
			PatientResponse patientResponse = new PatientResponse();
			if (patientServices.deletePatient(patientEmail)) {
				patientResponse.setStatusCode(201);
				patientResponse.setMessage("Success");
				patientResponse.setDescription("Doctor Deleted Successfully");
			}
			return patientResponse;
		}

		@GetMapping(path = "/search-patient/{patientId}")
		public PatientResponse searchPatient(@PathVariable("patientId") int patientId) {
			PatientResponse patientResponse = new PatientResponse();
			Patient patient = patientServices.searchPatient(patientId);
			if (patient != null) {
				patientResponse.setStatusCode(201);
				patientResponse.setMessage("Success");
				patientResponse.setDescription("Doctor Found Successfully");
				patientResponse.setPatient(Arrays.asList(patient));
			}
			return patientResponse;
		}
				
}
	

