package com.capgemini.jst.SpringCapmates.transferObjects;





public class StatisticsDto {
	private long userId;
	private Integer averageScore;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private int gamesPlayed;
	private int level;
	
	
	public Integer getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Integer averageScore) {
		this.averageScore = averageScore;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
