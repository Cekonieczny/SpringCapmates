package com.capgemini.jst.SpringCapmates.repositories;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.SpringCapmates.data.Game;

@Repository
public class GamesDao {
	private List<Game> listOfGames;

	@Autowired
	private GamesDao() {
		listOfGames = new LinkedList<>();
		listOfGames.add(new Game(1L, "Agricola"));
		listOfGames.add(new Game(2L, "Civilization"));
		listOfGames.add(new Game(3L, "Gloomhaven"));
		listOfGames.add(new Game(4L, "Gaia Project"));
		listOfGames.add(new Game(5L, "Scythe"));
		listOfGames.add(new Game(6L, "Puerto Rico"));
	}

	public List<Game> findAll() {
		return listOfGames;
	}

	public void addNewGame(String gameName) {
		this.listOfGames.add(new Game(System.currentTimeMillis(), gameName));
	}

	public void deleteGame(Long gameId){
		for(Game game:listOfGames){
			if(game.getGameId().equals(gameId)){
				listOfGames.remove(game);
			}
		}
	}

}
