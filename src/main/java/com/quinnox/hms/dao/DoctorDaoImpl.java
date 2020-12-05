package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addDoctor(Doctor doctor) {
		manager.persist(doctor);
		return true;

	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		String jpql = "update Doctor set firstName = :fname, lastName=:lname,doctorId=:did, specialization=:spcl,"
				+ "ratings=:rating, doctorEmail=:eml, clinicName=: clinic where doctorEmail=:eml";
		Query query = manager.createQuery(jpql);
		query.setParameter("fname", doctor.getFirstName());
		query.setParameter("lname", doctor.getLastName());
		query.setParameter("spcl", doctor.getSpecialization());
		query.setParameter("rating", doctor.getRatings());
		query.setParameter("eml", doctor.getDoctorEmail());
		query.setParameter("clinic", doctor.getClinicName());
		query.setParameter("did", doctor.getDoctorId());

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteDoctor(String doctorEmail) {
		String jpql = "delete from doctorEmail=: emal";
		Query query = manager.createQuery(jpql);
		query.setParameter("emal", doctorEmail);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;

		} else
			return false;
	}

	@Override
	public Doctor searchDoctor(int doctorId) {
		Doctor doctor1;
		doctor1 = manager.find(Doctor.class, doctorId);
		if (doctor1 != null) {
			return doctor1;
		}
		return null;
	}

	@Override
	public ArrayList<Doctor> getAllDoctor() {
		String jpql = "from Appointment ";
		Query query = manager.createQuery(jpql, Appointment.class);
		ArrayList<Doctor> doctor = (ArrayList<Doctor>) query.getResultList();
		if (doctor != null && doctor.size() != 0) {
			return doctor;
		}
		return null;

	}

	@Override
	public boolean updateDoctorRatings(Doctor doctor) {
		String jpql = "update Doctor set ratings=:rating where doctorId = :did";
		Query query = manager.createQuery(jpql);
		query.setParameter("rating", doctor.getRatings());
		query.setParameter("did", doctor.getDoctorId());

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

}
