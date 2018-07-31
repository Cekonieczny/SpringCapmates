package com.capgemini.jst.SpringCapmates.test.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.repositories.GamesDao;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;
import com.capgemini.jst.SpringCapmates.services.UserGameCollectionService;
import com.capgemini.jst.SpringCapmates.transferObjects.FindGamesByParamsRequestDto;
import com.capgemini.jst.SpringCapmates.transferObjects.GameDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameCollectionServiceTest {

	@Autowired
	UserGameCollectionService userGameCollectionService;

	@Autowired
	GamesDao gamesDao;

	@Autowired
	UserDao userDao;

	@Test
	public void addGameToUserCollection() throws Exception {
		// given
		Long gameId = 2L;
		Long userId = 8L;
		// when

		userGameCollectionService.addGameToUserCollection(userId, gameId);
		User user = userDao.find(userId);
		// then
		assertEquals(gameId, user.getGameCollection().get(3).getGameId());
	}

	@Test
	public void addGameToGeneralCollection() throws Exception {
		// given
		String gameName = "Chaos in The old World";
		Integer minimalNumberOfPlayers = 2;
		Integer maximalNumberOfPlayers = 5;
		GameDto gameDto = new GameDto(gameName, minimalNumberOfPlayers, maximalNumberOfPlayers);
		// when

		userGameCollectionService.addNewGameToGeneralCollection(gameDto);
		List<Game> list = gamesDao.findAll();
		// then
		assertEquals(gameName, list.get(6).getGameName());
	}

	@Test
	public void getFilteredGeneralCollection() {
		// given
		FindGamesByParamsRequestDto findGameByParamsDto = new FindGamesByParamsRequestDto("Aicola", 1, 4);
		// when
		List<Game> list = userGameCollectionService.findGamesByParams(findGameByParamsDto);
		// then
		System.out.println(list.iterator().next().getGameName());
	}

}
