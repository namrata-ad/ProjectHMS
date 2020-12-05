package com.quinnox.hms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.hms.dao.HistoryDao;
import com.quinnox.hms.dto.History;

@Service
public class HistoryServiceImpl implements HistoryService {
	@Autowired
	HistoryDao historydao;

	@Override
	public boolean addHistory(History history) {
		return historydao.addHistory(history);
	}

	@Override
	public boolean deleteHistory(int historyId) {
		return historydao.deleteHistory(historyId);
	}

	@Override
	public ArrayList<History> getAllHistory() {
		return historydao.getAllHistory();
	}

}
