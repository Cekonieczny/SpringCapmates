package com.capgemini.jst.SpringCapmates.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.data.User;

@Repository
public class UserDao {
	List<User> listOfUsers;

	private UserDao() {
		listOfUsers = new ArrayList<>();
		List<Game> gameCollection1 = new LinkedList<>();
		gameCollection1.add(new Game(1L, "Agricola"));
		gameCollection1.add(new Game(2L, "Civilization"));
		gameCollection1.add(new Game(3L, "Gloomhaven"));
		gameCollection1.add(new Game(4L, "Gaia Project"));
		gameCollection1.add(new Game(5L, "Scythe"));
		gameCollection1.add(new Game(6L, "Puerto Rico"));
		List<Game> gameCollection2 = new LinkedList<>();
		gameCollection2.add(new Game(1L, "Agricola"));
		gameCollection2.add(new Game(5L, "Scythe"));
		gameCollection2.add(new Game(4L, "Gaia Project"));
		List<Game> gameCollection3 = new LinkedList<>();
		gameCollection3.add(new Game(3L, "Gloomhaven"));
		gameCollection3.add(new Game(2L, "Civilization"));
		gameCollection3.add(new Game(4L, "Gaia Project"));
		gameCollection3.add(new Game(5L, "Scythe"));
		List<Game> gameCollection4 = new LinkedList<>();
		gameCollection4.add(new Game(3L, "Gloomhaven"));
		gameCollection4.add(new Game(2L, "Civilization"));
		List<Game> gameCollection5 = new LinkedList<>();
		gameCollection5.add(new Game(2L, "Civilization"));
		List<Game> gameCollection6 = new LinkedList<>();
		gameCollection6.add(new Game(1L, "Agricola"));
		gameCollection6.add(new Game(2L, "Civilization"));
		gameCollection6.add(new Game(4L, "Gaia Project"));
		List<Game> gameCollection7 = new LinkedList<>();
		List<Game> gameCollection8 = new LinkedList<>();
		gameCollection1.add(new Game(5L, "Scythe"));
		gameCollection1.add(new Game(3L, "Gloomhaven"));
		gameCollection1.add(new Game(4L, "Gaia Project"));
		listOfUsers
				.add(new User(4, "Jan", "Kowalski", "haslo123", 1L, "jan.kowalski@abc.com", "motto1", gameCollection1));
		listOfUsers.add(new User(20, "Jan", "Nowak", "h123", 2L, "jan.kowalski@abc.com", "motto1", gameCollection2));
		listOfUsers.add(
				new User(12, "Andrzej", "Wiśniewski", "hlo123", 3L, "jan.kowalski@abc.com", "motto1", gameCollection3));
		listOfUsers.add(
				new User(34, "Janusz", "Gruszecki", "haso123", 4L, "jan.kowalski@abc.com", "motto1", gameCollection4));
		listOfUsers.add(new User(55, "Wojciech", "Truskawski", "hasl13", 5L, "jan.kowalski@abc.com", "motto1",
				gameCollection5));
		listOfUsers.add(
				new User(66, "Tomasz", "Malinowski", "haslo3", 6L, "jan.kowalski@abc.com", "motto1", gameCollection6));
		listOfUsers.add(
				new User(123, "Piotr", "Poziomski", "ho123", 7L, "jan.kowalski@abc.com", "motto1", gameCollection7));
		listOfUsers
				.add(new User(66, "Paweł", "Porzecki", "has23", 8L, "jan.kowalski@abc.com", "motto1", gameCollection8));
	}

	public User find(Long userId) {
		for (User user : listOfUsers) {
			if (user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	public List<User> findAll() {
		return listOfUsers;
	}

	public void create(User user) {
		listOfUsers.add(user);
	}

	public void remove(User user) {
		listOfUsers.remove(user.getId());
	}

	public void update(User user) {
		listOfUsers.remove(find(user.getId()));
		listOfUsers.add(user);
	}

}
