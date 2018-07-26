package com.capgemini.jst.SpringCapmates.data;

import java.util.List;

public class User {
	private Long userId;
	private String userFirstName;
	private String userLastName;
	private String eMailAddress;
	private String password;
	private String lifeMotto;
	private List<Game> gameCollection;
	
	public User(Long userId, String userFirstName, String userLastName, String password, String eMailAddress,
			String lifeMotto, List<Game> gameCollection) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMailAddress = eMailAddress;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.gameCollection = gameCollection;
	}
	
	public User(){
		
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getEMailAddress() {
		return eMailAddress;
	}

	public void setEMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public List<Game> getGameCollection() {
		return gameCollection;
	}

	public void setGameCollection(List<Game> gameCollection) {
		this.gameCollection = gameCollection;
	}

}
