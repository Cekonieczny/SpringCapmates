package com.capgemini.jst.SpringCapmates.transferObjects;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

public class ChallengeDto {
	private Long challengedPlayerId;
	private Long challengingPlayerId;
	private LocalTime from;
	private LocalTime to;
	private LocalDate date;
	
	public ChallengeDto(Long challengedPlayerId, Long challengingPlayerId, LocalTime from, LocalTime to,
			LocalDate date) {
		super();
		this.challengedPlayerId = challengedPlayerId;
		this.challengingPlayerId = challengingPlayerId;
		this.from = from;
		this.to = to;
		this.date = date;
	}
	
	public ChallengeDto() {
	}

	public Long getChallengedPlayerId() {
		return challengedPlayerId;
	}
	public void setChallengedPlayerId(Long challengedPlayerId) {
		this.challengedPlayerId = challengedPlayerId;
	}
	public Long getChallengingPlayerId() {
		return challengingPlayerId;
	}
	public void setChallengingPlayerId(Long challengingPlayerId) {
		this.challengingPlayerId = challengingPlayerId;
	}
	public LocalTime getFrom() {
		return from;
	}
	public void setFrom(LocalTime from) {
		this.from = from;
	}
	public LocalTime getTo() {
		return to;
	}
	public void setTo(LocalTime to) {
		this.to = to;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
