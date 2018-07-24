package com.capgemini.jst.transferObjects;

import java.util.Date;

import org.springframework.stereotype.Service;



@Service
public class StatisticsDto {
 
	private int averageResult;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private int gamesPlayed;
	
	public int getAverageResult() {
		return averageResult;
	}
	public void setAverageResult(int averageResult) {
		this.averageResult = averageResult;
	}
	public int getGamesWon() {
		return gamesWon;
	}
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	public int getGamesLost() {
		return gamesLost;
	}
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}
	public int getGamesDrawn() {
		return gamesDrawn;
	}
	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

}
