package com.capgemini.jst.data;

import java.util.concurrent.atomic.AtomicLong;

public class History {
	private AtomicLong gameId;
	private Verdict verdict;
	private Integer score;
	private AtomicLong userId;

	public History(AtomicLong gameId, AtomicLong userId, Integer score, Verdict verdict) {
		this.gameId = gameId;
		this.verdict = verdict;
		this.score = score;
		this.userId = userId;
	}

	public AtomicLong getGameId() {
		return gameId;
	}

	public void setGameId(AtomicLong gameId) {
		this.gameId = gameId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public AtomicLong getUserId() {
		return userId;
	}

	public void setUserId(AtomicLong userId) {
		this.userId = userId;
	}

	public Verdict getVerdict() {
		return verdict;
	}

	public void setVerdict(Verdict verdict) {
		this.verdict = verdict;
	}

}
