package com.capgemini.jst.SpringCapmates.data;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserHoursOfAvailability {
	private Long userHoursOfAvailabilityId;
	private LocalTime from;
	private LocalTime to;
	private LocalDate date;
	private Long userId;
	private String comment;
	private boolean active = true;

	public UserHoursOfAvailability(Long userHoursOfAvailabilityId, LocalTime from, LocalTime to, LocalDate date,
			Long userId) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.userId = userId;
		this.setUserHoursOfAvailabilityId(userHoursOfAvailabilityId);
	}

	public UserHoursOfAvailability() {

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

	public Long getUserHoursOfAvailabilityId() {
		return userHoursOfAvailabilityId;
	}

	public void setUserHoursOfAvailabilityId(Long userHoursOfAvailabilityId) {
		this.userHoursOfAvailabilityId = userHoursOfAvailabilityId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
