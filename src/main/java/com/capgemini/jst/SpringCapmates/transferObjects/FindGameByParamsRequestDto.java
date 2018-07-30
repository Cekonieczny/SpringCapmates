package com.capgemini.jst.SpringCapmates.transferObjects;

public class FindGameByParamsRequestDto {

	private String gameNameLike = null;
	private Integer minimalNumberOfPlayers = null;
	private Integer maximalNumberOfPlayers = null;

	public FindGameByParamsRequestDto(String gameNameLike, Integer minimalNumberOfPlayers,
			Integer maximalNumberOfPlayers) {
		this.gameNameLike = gameNameLike;
		this.minimalNumberOfPlayers = minimalNumberOfPlayers;
		this.maximalNumberOfPlayers = maximalNumberOfPlayers;
	}

	public FindGameByParamsRequestDto() {

	}

	public String getGameNameLike() {
		return gameNameLike;
	}

	public void setGameNameLike(String gameNameLike) {
		this.gameNameLike = gameNameLike;
	}

	public Integer getMinimalNumberOfPlayers() {
		return minimalNumberOfPlayers;
	}

	public void setMinimalNumberOfPlayers(Integer minimalNumberOfPlayers) {
		this.minimalNumberOfPlayers = minimalNumberOfPlayers;
	}

	public Integer getMaximalNumberOfPlayers() {
		return maximalNumberOfPlayers;
	}

	public void setMaximalNumberOfPlayers(Integer maximalNumberOfPlayers) {
		this.maximalNumberOfPlayers = maximalNumberOfPlayers;
	}

}
