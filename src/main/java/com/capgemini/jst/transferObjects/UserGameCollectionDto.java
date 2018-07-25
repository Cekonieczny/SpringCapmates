package com.capgemini.jst.transferObjects;

import java.util.List;

import com.capgemini.jst.data.Game;

public class UserGameCollectionDto {
	private Long userId;
	private List<Game> gameCollection;

	public UserGameCollectionDto(Long userId, List<Game> gameCollection) {
		this.userId = userId;
		this.gameCollection = gameCollection;
	}

	public List<Game> getGameCollection() {
		return gameCollection;
	}

	public void setGameCollection(List<Game> gameCollection) {
		this.gameCollection = gameCollection;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
