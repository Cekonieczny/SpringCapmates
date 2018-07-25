package com.capgemini.jst.SpringCapmates.data;

import java.util.List;

public class User {
	private int userLevel;
	private String userFirstName;
	private String userLastName;
	private String password;
	private Long userId;
	private String eMailAddress;
	private String lifeMotto;
	private List<Game> gameCollection;

	public User(int userLevel, String userFirstName, String userLastName, String password, Long userId, String eMailAddress, String lifeMotto,
			List<Game> gameCollection) {
		this.userLevel = userLevel;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.password = password;
		this.userId = userId;
		this.eMailAddress = eMailAddress;
		this.lifeMotto = lifeMotto;
		this.gameCollection = gameCollection;

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

	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
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
