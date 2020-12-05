package com.quinnox.hms.dao;

import java.util.ArrayList;

import com.quinnox.hms.dto.History;

public interface HistoryDao {
public boolean addHistory(History history);
	
	public boolean deleteHistory(int historyId);
	
	public ArrayList<History> getAllHistory();

}
