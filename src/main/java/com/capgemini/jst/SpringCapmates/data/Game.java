package com.capgemini.jst.SpringCapmates.data;

public class Game {
	private Long gameId;
	private String gameName;
	private int minimalNumberOfPlayers;
	private int maximalNumberOfPlayers;

	public Game( Long gameId, String gameName,int minimalNumberOfPlayers, int maximalNumberOfPlayers) {
		this.gameName = gameName;
		this.gameId = gameId;
		this.minimalNumberOfPlayers = minimalNumberOfPlayers;
		this.maximalNumberOfPlayers = maximalNumberOfPlayers;
	}

	public Game() {
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public int getMinimalNumberOfPlayers() {
		return minimalNumberOfPlayers;
	}

	public void setMinimalNumberOfPlayers(int minimalNumberOfPlayers) throws Exception {
		if (minimalNumberOfPlayers <= 20 && minimalNumberOfPlayers >= 1) {
			this.minimalNumberOfPlayers = minimalNumberOfPlayers;
		}else{
			throw new Exception("Given minimal number of players is incorrect");
		}
		
	}

	public int getMaximalNumberOfPlayers() {
		return maximalNumberOfPlayers;
	}

	public void setMaximalNumberOfPlayers(int maximalNumberOfPlayers) throws Exception {
		if (maximalNumberOfPlayers <= 20 && maximalNumberOfPlayers >= 1) {
			this.maximalNumberOfPlayers = maximalNumberOfPlayers;
		}else{
			throw new Exception("Given maximal number of players is incorrect");
		}
	}

}
