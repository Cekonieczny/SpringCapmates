package com.capgemini.jst.SpringCapmates.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserMapper;
import com.capgemini.jst.SpringCapmates.repositories.GamesDao;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;

@Service
public class UserGameCollectionService {
	private final GamesDao gamesDao;
	private final UserDao userDao;
	private final UserMapper userMapper;

	@Autowired
	public UserGameCollectionService(GamesDao gamesDao, UserDao userDao, UserMapper userMapper) {
		this.gamesDao = gamesDao;
		this.userDao = userDao;
		this.userMapper = userMapper;
	}

	public UserGameCollectionDto addGameToUserCollection(Long userId, Long gameId) throws Exception {
		List<Game> availableGames = gamesDao.findAll();
		
		UserGameCollectionDto userGameCollectionDto = userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
		List<Game> userGameCollection = userGameCollectionDto.getGameCollection();
		
		Game newGameInUserCollection = null;

		for (Game game : availableGames) {
			if (gameId.equals(game.getGameId())) {
				newGameInUserCollection = game;
			} else {
				throw new Exception("There is no such game in general collection");
			}
		}
		for (Game game : userGameCollection) {
			if (gameId.equals(game.getGameId())) {
				throw new Exception("This game already exists in user collection");
		}
		userGameCollection.add(newGameInUserCollection);
		userGameCollectionDto.setGameCollection(userGameCollection);
		userGameCollectionDto.setUserId(userId);
		return userGameCollectionDto;
	}
	
	public UserGameCollectionDto removeGameFromUserCollection(Long userId, Long gameId) throws Exception{
		UserGameCollectionDto userGameCollectionDto = userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
		List<Game> userGameCollection = userGameCollectionDto.getGameCollection();
	
		for (Game game : userGameCollection) {
			if (gameId.equals(game.getGameId())) {
				userGameCollection.remove(game);
			} else {
				throw new Exception("There is no such game in user collection");
			}
		}
		userGameCollectionDto.setGameCollection(userGameCollection);
		userGameCollectionDto.setUserId(userId);
		return userGameCollectionDto;
	}
	
	public void removeGameFromUserCollection(Long userId) {

	}

	public void getGameCollection(Long userId) {

	}

}
