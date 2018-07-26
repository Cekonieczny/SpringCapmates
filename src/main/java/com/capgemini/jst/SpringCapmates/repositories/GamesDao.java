package com.capgemini.jst.SpringCapmates.repositories;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.SpringCapmates.data.Game;

@Repository
public class GamesDao {
	private List<Game> listOfGames;

	
	private GamesDao() {
		listOfGames = new LinkedList<>();
		listOfGames.add(new Game(1L, "Agricola", 1, 4));
		listOfGames.add(new Game(2L, "Civilization", 2, 4));
		listOfGames.add(new Game(3L, "Gloomhaven", 2, 4));
		listOfGames.add(new Game(4L, "Gaia Project", 2, 4));
		listOfGames.add(new Game(5L, "Scythe", 2, 4));
		listOfGames.add(new Game(6L, "Puerto Rico", 2, 4));
	}

	public List<Game> findAll() {
		return listOfGames;
	}

	public void create(Game game) {
		if (game.getGameId() != null) {
			throw new IllegalArgumentException("Game is already created, the game ID is not null.");
		} else {
			game.setGameId(System.currentTimeMillis());
			this.listOfGames.add(game);
		}
	}
}
