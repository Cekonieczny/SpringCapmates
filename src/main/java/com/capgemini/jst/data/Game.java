package com.capgemini.jst.data;

import java.util.concurrent.atomic.AtomicLong;

public class Game {
	private String gameName;
	private AtomicLong gameId;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public AtomicLong getGameId() {
		return gameId;
	}

	public void setGameId(AtomicLong  gameId) {
		this.gameId = gameId;
	}

}
