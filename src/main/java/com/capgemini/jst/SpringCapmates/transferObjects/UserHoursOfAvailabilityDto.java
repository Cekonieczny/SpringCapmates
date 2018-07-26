package com.capgemini.jst.SpringCapmates.transferObjects;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

public class UserHoursOfAvailabilityDto {
	private LocalTime from;
	private LocalTime to;
	private LocalDate date;
	private String comment;
	
	public UserHoursOfAvailabilityDto(LocalTime from, LocalTime to, LocalDate date,String comment) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}