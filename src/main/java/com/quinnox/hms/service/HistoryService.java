package com.quinnox.hms.service;

import java.util.ArrayList;

import com.quinnox.hms.dto.History;

public interface HistoryService {
	public boolean addHistory(History history);

	public boolean deleteHistory(int historyId);

	public ArrayList<History> getAllHistory();

}
