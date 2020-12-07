package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Contact;
import com.quinnox.hms.dto.Patient;
import com.quinnox.hms.exception.HospitalException;
@Repository
public class PatientDaoImpl implements PatientDao {
@Autowired
EntityManager manager;
	@Override
	@Transactional
	public boolean addPatient(Patient patient) {
		//System.out.println("---------"+patient);
		manager.merge(patient);
		return true;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		String jpql = "update patient set patientAddress=:paddress, patientGender=:pgender,patientHealIssue=:phealthissue,patientEmail=:pemail,patientFirstname=:pfirstname, patientLastName=:plastname "
				+ "patientStatus=:sts where patientId = : pid";
		Query query = manager.createQuery(jpql);
		query.setParameter("paddress", patient.getAddress());
		query.setParameter("pgender", patient.getGender());
		query.setParameter("phealthissue", patient.getHealthIssue());
		query.setParameter("pemail", patient.getPatientEmail());
		query.setParameter("pfirstname", patient.getPatientFirstName());
		query.setParameter("plastname", patient.getPatientLastName());

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public boolean deletePatient(String patientEmail) {
		String jpql = "delete from Appointment where appointmentId = : aid ";
		Query query = manager.createQuery(jpql);
		query.setParameter("aid", patientEmail);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public Patient searchPatient(int patientId) {
		Patient patient1;
		patient1 = manager.find(Patient.class, patientId);
		if (patient1 != null) {
			return patient1;
		}
		return patient1;
	}

	@Override
	public ArrayList<Patient> getAllPatient() 
	{
		String jpql = " from patient";
		Query query = manager.createQuery(jpql, Patient.class);
		ArrayList<Patient> patientList = (ArrayList<Patient>) query.getResultList();
		if (patientList != null && patientList.size() != 0) 
		{
			return patientList;
		}
		return patientList;
	}
}