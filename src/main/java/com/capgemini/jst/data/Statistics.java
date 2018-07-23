package com.capgemini.jst.data;

import java.util.Date;

public class Statistics {
	private Date dateOfPlayedGame;
	private int score;
	private int position;
	public Date getDateOfPlayedGame() {
		return dateOfPlayedGame;
	}
	public void setDateOfPlayedGame(Date dateOfPlayedGame) {
		this.dateOfPlayedGame = dateOfPlayedGame;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}

}
