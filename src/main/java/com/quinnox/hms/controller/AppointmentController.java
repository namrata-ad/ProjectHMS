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

import com.quinnox.hms.dao.AppointmentDao;
import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.response.AppointmentResponse;
import com.quinnox.hms.response.DoctorResponse;

@SuppressWarnings("unused")
public class AppointmentController {
	@Autowired
	AppointmentDao appointmentservices;
	@PostMapping(path="/add-appointment")
	public DoctorResponse addDoctor(@RequestBody Appointment appointment) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (appointmentservices.addAppointment(appointment)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Appointment Added Successfully");
		}
		else {
			doctorResponse.setStatusCode(401);
			doctorResponse.setMessage("error");
			doctorResponse.setDescription("Something went wrong");
		}
		return doctorResponse;
		
	}
	@GetMapping(path = "/get-all-appointment")
	public AppointmentResponse getAllAppointment() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentservices.getAllAppointment();
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(appointmentList);;
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	@PutMapping(path = "/modify-appointment")
	public AppointmentResponse updateAppointment(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentservices.updateAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment updated Successfully");
		}
		return appointmentResponse;
	}

	@DeleteMapping(path = "/delete-appointment")
	public AppointmentResponse deleteResponse(@PathVariable("appointmentid") int appointmentid) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentservices.deleteAppointment(appointmentid)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Deleted Successfully");
		}
		return appointmentResponse;
	}

	@GetMapping(path = "/search-appointment/{appoinmentId}")
	public AppointmentResponse searchAppointment(@PathVariable("appoinmentId") int appoinmentId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		Appointment appointment = appointmentservices.searchAppointment(appoinmentId);
		if (appointment != null) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
		}
		return appointmentResponse;
	}
	
}
