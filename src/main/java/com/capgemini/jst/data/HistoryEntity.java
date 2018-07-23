package com.capgemini.jst.data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;

public class HistoryEntity {
	private Date dateOfPlayedGame;
	private List<int []> listOfUserIDs;
	private Statistics statistics;

	public Date getDateOfPlayedGame() {
		return dateOfPlayedGame;
	}

	public void setDateOfPlayedGame(Date dateOfPlayedGame) {
		this.dateOfPlayedGame = dateOfPlayedGame;
	}

	public List getListOfUserIDs() {
		return listOfUserIDs;
	}

	public void setListOfUserIDs(List listOfUserIDs) {
		this.listOfUserIDs = listOfUserIDs;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	
	
	
}
