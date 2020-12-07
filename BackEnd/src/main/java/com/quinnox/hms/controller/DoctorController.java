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

import com.quinnox.hms.dao.DoctorDao;
import com.quinnox.hms.dto.Doctor;
import com.quinnox.hms.response.DoctorResponse;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorDao doctorServices;
	@PostMapping(path="/add-doctor")
	public DoctorResponse addDoctor(@RequestBody Doctor doctor) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.addDoctor(doctor)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Added Successfully");
		}
		else {
			doctorResponse.setStatusCode(401);
			doctorResponse.setMessage("error");
			doctorResponse.setDescription("Something went wrong");
		}
		return doctorResponse;
		
	}
	@GetMapping(path = "/get-all-doctor")
	public DoctorResponse getAllDoctor() {
		DoctorResponse doctorResponse = new DoctorResponse();
		List<Doctor> doctorList = doctorServices.getAllDoctor();
		if (doctorList.size() != 0) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Found Successfully");
			doctorResponse.setDoctor(doctorList);
			return doctorResponse;
		}
		return doctorResponse;
	}
	@PutMapping(path = "/modify-doctor")
	public DoctorResponse updateDoctor(@RequestBody Doctor doctor) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.updateDoctor(doctor)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Modified Successfully");
		}
		return doctorResponse;
	}

	@DeleteMapping(path = "/delete-doctor/{doctorEmail}")
	public DoctorResponse deleteDoctor(@PathVariable("doctorEmail") String doctorEmail) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.deleteDoctor(doctorEmail)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Deleted Successfully");
		}
		return doctorResponse;
	}

	@GetMapping(path = "/search-doctor/{doctorId}")
	public DoctorResponse searchDoctor(@PathVariable("doctorId") int doctorId) {
		DoctorResponse doctorResponse = new DoctorResponse();
		Doctor doctor = doctorServices.searchDoctor(doctorId);
		if (doctor != null) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Found Successfully");
			doctorResponse.setDoctor(Arrays.asList(doctor));
		}
		return doctorResponse;
	}
	
}
