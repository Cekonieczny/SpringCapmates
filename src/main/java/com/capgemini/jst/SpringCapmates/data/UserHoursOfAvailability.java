package com.capgemini.jst.SpringCapmates.data;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserHoursOfAvailability {
	private LocalTime from;
	private LocalTime to;
	private LocalDate date;
	private Long userId;
	private String comment;
	private boolean status;

	public UserHoursOfAvailability(LocalTime from, LocalTime to, LocalDate date, Long userId, String comment,
			boolean status) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.userId = userId;
		this.comment = comment;
		this.status = status;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
