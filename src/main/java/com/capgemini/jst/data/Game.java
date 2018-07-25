package com.capgemini.jst.data;

public class Game {
	private String gameName;
	private Long gameId;

	public Game(Long gameId, String gameName) {
		this.gameId = gameId;
		this.gameName = gameName;
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

}
