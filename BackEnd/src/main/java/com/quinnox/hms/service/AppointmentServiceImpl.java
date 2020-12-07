package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.AppointmentDao;
import com.quinnox.hms.dto.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentDao appointmentdao;

	@Override
	public boolean addAppointment(Appointment appointment) {
		return appointmentdao.addAppointment(appointment);
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		return appointmentdao.updateAppointment(appointment);
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		return appointmentdao.deleteAppointment(appointmentId);
	}

	@Override
	public Appointment searchAppointment(int appointmentId) {
		return appointmentdao.searchAppointment(appointmentId);
	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		return appointmentdao.getAllAppointment();
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId) {
		return appointmentdao.getAllAppointmentDoctor(doctorId);
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId) {
		return appointmentdao.getAllAppointmentPatient(patientId);
	}

}
