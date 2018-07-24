package com.capgemini.jst.data;

import java.util.concurrent.atomic.AtomicLong;

import com.capgemini.jst.transferObjects.StatisticsDto;

public class User {
	private int userLevel;
	private String userFirstName;
	private String password;
	private int userHoursOfAvailability;
	private AtomicLong id;
	private String eMailAddress;
	

	public User(int userLevel,String userName,String password,int userHoursOfAvailability,AtomicLong id){
		
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserName() {
		return userFirstName;
	}

	public void setUserName(String userName) {
		this.userFirstName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserHoursOfAvailability() {
		return userHoursOfAvailability;
	}

	public void setUserHoursOfAvailability(int userHoursOfAvailability) {
		this.userHoursOfAvailability = userHoursOfAvailability;
	}

	public AtomicLong getId() {
		return id;
	}

	public void setId(AtomicLong id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof User) && (id != null) ? id.equals(((User) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	public String getEMailAddress() {
		return eMailAddress;
	}

	public void setEMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

}
