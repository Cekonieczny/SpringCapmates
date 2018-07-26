package com.capgemini.jst.SpringCapmates.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.mappers.GameMapper;
import com.capgemini.jst.SpringCapmates.mappers.UserMapper;
import com.capgemini.jst.SpringCapmates.transferObjects.GameDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.SpringCapmates.repositories.GamesDao;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;

@Service
public class UserGameCollectionService {
	private final GamesDao gamesDao;
	private final UserMapper userMapper;
	private final UserDao userDao;
	private final GameMapper gameMapper;

	@Autowired
	public UserGameCollectionService(GamesDao gamesDao, GameMapper gameMapper, UserMapper userMapper, UserDao userDao) {
		this.gamesDao = gamesDao;
		this.userMapper = userMapper;
		this.userDao = userDao;
		this.gameMapper = gameMapper;
	}

	public void addGameToUserCollection(Long userId, Long gameId) throws Exception {
		List<Game> availableGames = gamesDao.findAll();

		List<Game> userGameCollection = userDao.find(userId).getGameCollection();

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
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto(userId, userGameCollection);
		userDao.update(userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto,
				userDao.find(userGameCollectionDto.getUserId())));

	}

	public Game removeGameFromUserCollection(Long userId, Long gameId) throws Exception {
		UserGameCollectionDto userGameCollectionDto = userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
		List<Game> userGameCollection = userGameCollectionDto.getGameCollection();
		Game removedGame = new Game();

		for (Game game : userGameCollection) {
			if (gameId.equals(game.getGameId())) {
				removedGame = game;
				userGameCollection.remove(game);
			} else {
				throw new Exception("There is no such game in user collection");
			}
		}
		userGameCollectionDto.setGameCollection(userGameCollection);
		userGameCollectionDto.setUserId(userId);

		userDao.update(userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto,
				userDao.find(userGameCollectionDto.getUserId())));

		return removedGame;

	}

	public UserGameCollectionDto getGameCollection(Long userId) {
		return userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
	}

	public void AddNewGameToGeneralCollection(GameDto gameDto) {
		Game game = new Game();
		gameMapper.mapGameDtoToGame(gameDto, game);
		gamesDao.create(game);
	}

}
