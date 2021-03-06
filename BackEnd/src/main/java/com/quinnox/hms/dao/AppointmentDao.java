package com.quinnox.hms.dao;

import java.util.ArrayList;

import com.quinnox.hms.dto.Appointment;

public interface AppointmentDao {
	public boolean addAppointment(Appointment appointment);

	public boolean updateAppointment(Appointment appointment);

	public boolean deleteAppointment(int appointmentId);

	public Appointment searchAppointment(int appointmentId);

	public ArrayList<Appointment> getAllAppointment();
	
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId);
	
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId);

}
