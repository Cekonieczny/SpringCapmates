package com.capgemini.jst.SpringCapmates.repositories;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.data.User;

@Repository
public class UserDao {
	List<User> listOfUsers;
	
	
	public UserDao() {
		listOfUsers = new LinkedList<>();
		List<Game> gameCollection1 = new LinkedList<>();
		gameCollection1.add(new Game(1L, "Agricola", 1, 4));
		gameCollection1.add(new Game(2L, "Civilization", 2, 4));
		gameCollection1.add(new Game(3L, "Gloomhaven", 2, 4));
		gameCollection1.add(new Game(4L, "Gaia Project", 2, 5));
		gameCollection1.add(new Game(5L, "Scythe", 2, 4));
		gameCollection1.add(new Game(6L, "Puerto Rico", 2, 4));
		List<Game> gameCollection2 = new LinkedList<>();
		gameCollection2.add(new Game(1L, "Agricola", 1, 4));
		gameCollection2.add(new Game(5L, "Scythe", 2, 4));
		gameCollection2.add(new Game(4L, "Gaia Project", 2, 5));
		List<Game> gameCollection3 = new LinkedList<>();
		gameCollection3.add(new Game(3L, "Gloomhaven", 2, 4));
		gameCollection3.add(new Game(2L, "Civilization", 2, 4));
		gameCollection3.add(new Game(4L, "Gaia Project", 2, 5));
		gameCollection3.add(new Game(5L, "Scythe", 2, 4));
		List<Game> gameCollection4 = new LinkedList<>();
		gameCollection4.add(new Game(3L, "Gloomhaven", 2, 4));
		gameCollection4.add(new Game(2L, "Civilization", 2, 4));
		List<Game> gameCollection5 = new LinkedList<>();
		gameCollection5.add(new Game(2L, "Civilization", 2, 4));
		List<Game> gameCollection6 = new LinkedList<>();
		gameCollection6.add(new Game(1L, "Agricola", 1, 4));
		gameCollection6.add(new Game(2L, "Civilization", 2, 4));
		gameCollection6.add(new Game(4L, "Gaia Project", 2, 5));
		List<Game> gameCollection7 = new LinkedList<>();
		List<Game> gameCollection8 = new LinkedList<>();
		gameCollection1.add(new Game(5L, "Scythe", 2, 4));
		gameCollection1.add(new Game(3L, "Gloomhaven", 2, 4));
		gameCollection1.add(new Game(4L, "Gaia Project", 2, 4));
		List<Game> gameCollection9 = new LinkedList<>();
		gameCollection1.add(new Game(5L, "Scythe", 2, 4));
		gameCollection1.add(new Game(3L, "Gloomhaven", 2, 4));
		gameCollection1.add(new Game(4L, "Gaia Project", 2, 4));
		listOfUsers.add(new User(1L, "Jan", "Kowalski", "haslo123", "jan.kowalski@abc.com", "motto1", gameCollection1));
		listOfUsers
				.add(new User(2L, "Jan", "Nowak", "hfdfd123", "jan.nowak@abc.com", "motto41", gameCollection2));
		listOfUsers.add(new User(3L, "Andrzej", "Wisniewski", "hlo123", "andrzej.wisniewski@abc.com", "motto451",
				gameCollection3));
		listOfUsers.add(
				new User(4L, "Janusz", "Gruszecki", "haso123", "gruszecki23.janusz@abc.com", "mott6o1", gameCollection4));
		listOfUsers.add(new User(5L, "Wojciech", "Truskawski", "hasl13", "truskawski.wojciech@abc.com", "motto71",
				gameCollection5));
		listOfUsers.add(
				new User(6L, "Tomasz", "Malinowski", "haslo3", "tomasz.malinowski@abc.com", "mot8to1", gameCollection6));
		listOfUsers.add(
				new User(7L, "Piotr", "Poziomski", "ho123", "poziomski.piotr@abc.com", "mott9o1", gameCollection7));
		listOfUsers
				.add(new User(8L, "Pawel", "Porzecki", "has23", "porzecki.pawel@abc.com", "motto10", gameCollection8));
		listOfUsers.add(
				new User(9L, "Michał", "Sliwinski", "has234", "michal.sliwinski@abc.com", "motto51", gameCollection9));
	}

	public User find(Long userId) {
		for (User user : listOfUsers) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	public List<User> findAll() {
		return listOfUsers;
	}

	public void create(User user) {
		if (user.getUserId() != null) {
			throw new IllegalArgumentException("User is already created, User is not null.");
		} else {
			user.setUserId(System.currentTimeMillis());
			listOfUsers.add(user);
		}
	}

	public void delete(User user) {
		if (user.getUserId() == null) {
			throw new IllegalArgumentException("User is not present in database");
		} else {
			listOfUsers.remove(user.getUserId());
		}
	}

	public void update(User user) {
		User userToUpdate = new User();
		for (User tempUser : listOfUsers) {
			if (tempUser.getUserId().equals(user.getUserId())) {
				userToUpdate = tempUser;
			}
			listOfUsers.remove(userToUpdate);
			listOfUsers.add(user);
			return;
		}
		
	}

}
