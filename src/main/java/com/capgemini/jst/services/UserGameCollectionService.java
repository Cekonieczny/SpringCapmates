package com.capgemini.jst.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jst.data.Game;
import com.capgemini.jst.data.History;
import com.capgemini.jst.exceptions.NoSuchGameInCollectionException;
import com.capgemini.jst.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.transferObjects.UserMapper;
import com.capgemini.jst.repositories.GamesDao;
import com.capgemini.jst.repositories.UserDao;

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
				userGameCollection.add(newGameInUserCollection);
			} else {
				throw new Exception("This game already exists in user collection");
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
