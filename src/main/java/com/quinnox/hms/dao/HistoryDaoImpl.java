package com.quinnox.hms.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.hms.dto.Appointment;
import com.quinnox.hms.dto.Contact;
import com.quinnox.hms.dto.History;
import com.quinnox.hms.exception.HospitalException;

@Repository
public class HistoryDaoImpl implements HistoryDao {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addHistory(History history) {
		manager.merge(history);
		return true;
	}

	@Override
	public boolean deleteHistory(int historyId) {
		String jpql = "delete from history where historyid=: hid";
		Query query = manager.createQuery(jpql);
		query.setParameter("hid", historyId);

		int i = query.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			throw new HospitalException("Enter the valid details");
		}
	}

	@Override
	public ArrayList<History> getAllHistory() {
		String jpql = " from History";
		Query query = manager.createQuery(jpql, History.class);
		ArrayList<History> HistoryList = (ArrayList<History>) query.getResultList();
		if (HistoryList != null && HistoryList.size() != 0) {
			return HistoryList;
		}
		return null;
	}

}
