package com.capgemini.jst.data;

public class UserEntity {
	private int userLevel;
	private String userName;
	private String password;
	private int userHoursOfAvailability;
	private Statistics statistics;
	private int userId;
		
	public int getUserLevel(){
		return userLevel;
	}
	
	public void setUserLevel(int userLevel){
		this.userLevel = userLevel;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
