package com.capgemini.jst.SpringCapmates.transferObjects;




public class UserProfileDto {
	private String userFirstName;
	private String userLastName;
	private String eMailAddress;
	private String password;
	private String lifeMotto;
	
	public UserProfileDto(String userFirstName, String userLastName, String eMailAddress, String password,
			String lifeMotto) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMailAddress = eMailAddress;
		this.password = password;
		this.lifeMotto = lifeMotto;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String geteMailAddress() {
		return eMailAddress;
	}
	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLifeMotto() {
		return lifeMotto;
	}
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
	

}
