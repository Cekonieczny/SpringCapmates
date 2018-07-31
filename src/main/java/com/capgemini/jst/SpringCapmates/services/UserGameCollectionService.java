package com.capgemini.jst.SpringCapmates.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.exceptions.NoSuchElementInDatabaseException;
import com.capgemini.jst.SpringCapmates.mappers.GameMapper;
import com.capgemini.jst.SpringCapmates.mappers.UserMapper;
import com.capgemini.jst.SpringCapmates.transferObjects.FindGamesByParamsRequestDto;
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

	public List<Game> getGeneralGameCollection() {
		return gamesDao.findAll();
	}

	public void addGameToUserCollection(Long userId, Long gameId) throws NoSuchElementInDatabaseException {
		List<Game> availableGames = gamesDao.findAll();

		List<Game> userGameCollection = userDao.find(userId).getGameCollection();

		Game newGameInUserCollection = null;

		for (Game game : availableGames) {
			if (gameId.equals(game.getGameId())) {
				newGameInUserCollection = game;
			}
		}
		if (newGameInUserCollection == null) {
			throw new NoSuchElementInDatabaseException();
		}

		for (Game game : userGameCollection) {
			if (gameId.equals(game.getGameId())) {
				throw new NoSuchElementInDatabaseException();
			}
		}
		userGameCollection.add(newGameInUserCollection);
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto(userId, userGameCollection);
		userDao.update(userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto,
				userDao.find(userGameCollectionDto.getUserId())));

	}

	public Game removeGameFromUserCollection(Long userId, Long gameId) throws NoSuchElementInDatabaseException {
		UserGameCollectionDto userGameCollectionDto = userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
		List<Game> userGameCollection = userGameCollectionDto.getGameCollection();
		Game removedGame = null;

		for (Game game : userGameCollection) {
			if (gameId.equals(game.getGameId())) {
				removedGame = game;
				break;
			}
		}
		if (removedGame == null) {
			throw new NoSuchElementInDatabaseException();
		}
		userGameCollection.remove(removedGame);
		userGameCollectionDto.setGameCollection(userGameCollection);
		userGameCollectionDto.setUserId(userId);

		userDao.update(userMapper.mapUserGameCollectionDtoToUser(userGameCollectionDto,
				userDao.find(userGameCollectionDto.getUserId())));

		return removedGame;
	}

	public UserGameCollectionDto getUserGameCollection(Long userId) throws NoSuchElementInDatabaseException {
		return userMapper.mapUserToUserGameCollectionDto(userDao.find(userId));
	}

	public void addNewGameToGeneralCollection(GameDto gameDto) {
		Game game = new Game();
		game = gameMapper.mapGameDtoToGame(gameDto, game);
		gamesDao.create(game);
	}

	public List<Game> findGamesByParams(FindGamesByParamsRequestDto findGamesByParamsRequestDto) {
		List<Game> listToFilter = gamesDao.findAll();

		if (findGamesByParamsRequestDto.getGameNameLike() != null) {
			listToFilter = filterByGameNames(listToFilter, findGamesByParamsRequestDto.getGameNameLike());
		}
		if (findGamesByParamsRequestDto.getMinimalNumberOfPlayers() != null) {
			listToFilter = filterByMinimalNumberOfPlayers(listToFilter,
					findGamesByParamsRequestDto.getMinimalNumberOfPlayers());
		}
		if (findGamesByParamsRequestDto.getMaximalNumberOfPlayers() != null) {
			listToFilter = filterByMaximalNumberOfPlayers(listToFilter,
					findGamesByParamsRequestDto.getMaximalNumberOfPlayers());
		}
		return listToFilter;
	}

	private List<Game> filterByGameNames(List<Game> listToFilter, String gameNameLike) {
		JaroWinklerDistance jaroWinklerDistance = new JaroWinklerDistance();

		return listToFilter.stream().filter(p -> jaroWinklerDistance.apply(p.getGameName(), gameNameLike) >= 0.7)
				.collect(Collectors.toList());
	}

	private List<Game> filterByMinimalNumberOfPlayers(List<Game> listToFilter, Integer minPlayers) {
		return listToFilter.stream().filter(p -> p.getMinimalNumberOfPlayers() == (minPlayers.intValue()))
				.collect(Collectors.toList());
	}

	private List<Game> filterByMaximalNumberOfPlayers(List<Game> listToFilter, Integer maxPlayers) {
		return listToFilter.stream().filter(p -> p.getMaximalNumberOfPlayers() == (maxPlayers.intValue()))
				.collect(Collectors.toList());
	}

}
