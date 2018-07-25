package com.capgemini.jst.data;

public class History {
	private Long gameId;
	private Verdict verdict;
	private Integer score;
	private Long userId;

	public History(Long gameId, Long userId, Integer score, Verdict verdict) {
		this.gameId = gameId;
		this.verdict = verdict;
		this.score = score;
		this.userId = userId;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Verdict getVerdict() {
		return verdict;
	}

	public void setVerdict(Verdict verdict) {
		this.verdict = verdict;
	}

}
