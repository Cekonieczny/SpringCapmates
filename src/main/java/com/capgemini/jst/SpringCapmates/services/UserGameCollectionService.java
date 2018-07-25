package com.capgemini.jst.SpringCapmates.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserMapper;
import com.capgemini.jst.SpringCapmates.repositories.GamesDao;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;

@Service
public class UserGameCollectionService {
	private final GamesDao gamesDao;
	private final UserMapper userMapper;

	@Autowired
	public UserGameCollectionService(GamesDao gamesDao, UserMapper userMapper) {
		this.gamesDao = gamesDao;
		this.userMapper = userMapper;
	}

	public User addGameToUserCollection(UserGameCollectionDto userGameCollectionDto, Long gameId) throws Exception {
		List<Game> availableGames = gamesDao.findAll();

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
		}
		userGameCollection.add(newGameInUserCollection);
		userGameCollectionDto.setGameCollection(userGameCollection);
		return userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto);

	}

	public User removeGameFromUserCollection(Long userId, Long gameId) throws Exception {
		UserGameCollectionDto userGameCollectionDto = userMapper.mapUserToUserGameCollectionDto(userId);
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
		return userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto);
		
	}

	public UserGameCollectionDto getGameCollection(Long userId) {
		return userMapper.mapUserToUserGameCollectionDto(userId);
	}

}
