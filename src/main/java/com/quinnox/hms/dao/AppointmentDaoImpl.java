package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.exception.HospitalException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addAppointment(Appointment appointment) {
		manager.merge(appointment);
		return true;

	}

	@Override
	@Transactional
	public boolean updateAppointment(Appointment appointment) {
		String jpql = "update Appointment set appointmentDate=:adate, appointmentTime=:atime, "
				+ "appointmentStatus=:sts where appointmentId = : aid";
		Query query = manager.createQuery(jpql);
		query.setParameter("adate", appointment.getAppointmentDate());
		query.setParameter("atime", appointment.getAppointmentTime());
		query.setParameter("sts", appointment.getAppointmentStatus());
		query.setParameter("aid", appointment.getAppointmentId());

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}

	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		String jpql = "delete from Appointment where appointmentId = : aid ";
		Query query = manager.createQuery(jpql);
		query.setParameter("aid", appointmentId);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public Appointment searchAppointment(int appointmentId) {
		Appointment appointment1;
		appointment1 = manager.find(Appointment.class, appointmentId);
		if (appointment1 != null) {
			
		}
		int i = 0;
		if(i>0){
			return appointment1;
		}else {
			throw new HospitalException("Enter the valid details");
		}												
		

	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		String jpql = "from Appointment ";
		Query query = manager.createQuery(jpql, Appointment.class);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		return null;
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId) {
		String jpql = "from Appointment where doctorId=:did ";
		Query query = manager.createQuery(jpql, Appointment.class);
		query.setParameter("did", doctorId);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		return null;
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId) {
		String jpql = "from Appointment where patientId=:pid ";
		Query query = manager.createQuery(jpql, Appointment.class);
		query.setParameter("pid", patientId);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		return null;
	}

}
