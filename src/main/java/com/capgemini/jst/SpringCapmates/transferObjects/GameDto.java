package com.capgemini.jst.SpringCapmates.transferObjects;

import org.springframework.stereotype.Service;

@Service
public class GameDto {
	private String gameName;
	private int minimalNumberOfPlayers;
	private int maximalNumberOfPlayers;
	
	public GameDto(String gameName, int minimalNumberOfPlayers, int maximalNumberOfPlayers) {
		this.gameName = gameName;
		this.minimalNumberOfPlayers = minimalNumberOfPlayers;
		this.maximalNumberOfPlayers = maximalNumberOfPlayers;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getMinimalNumberOfPlayers() {
		return minimalNumberOfPlayers;
	}
	public void setMinimalNumberOfPlayers(int minimalNumberOfPlayers) {
		this.minimalNumberOfPlayers = minimalNumberOfPlayers;
	}
	public int getMaximalNumberOfPlayers() {
		return maximalNumberOfPlayers;
	}
	public void setMaximalNumberOfPlayers(int maximalNumberOfPlayers) {
		this.maximalNumberOfPlayers = maximalNumberOfPlayers;
	}

}
