package com.capgemini.jst.SpringCapmates.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.repositories.GamesDao;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;
import com.capgemini.jst.SpringCapmates.services.UserGameCollectionService;


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
	public void addGameToUserCollection() throws Exception{
		//given
		Long gameId = 1L;
		Long userId = 8L;
		//when
		
		userGameCollectionService.addGameToUserCollection(userId,gameId);
		User user = userDao.find(userId);
		//then
		assertEquals(gameId,user.getGameCollection().get(0).getGameId());
	}


}
