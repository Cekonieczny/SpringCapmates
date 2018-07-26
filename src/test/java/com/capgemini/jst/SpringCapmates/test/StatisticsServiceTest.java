package com.capgemini.jst.SpringCapmates.test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.SpringCapmates.data.History;
import com.capgemini.jst.SpringCapmates.data.Verdict;
import com.capgemini.jst.SpringCapmates.repositories.HistoryDao;
import com.capgemini.jst.SpringCapmates.services.UserStatisticsService;
import com.capgemini.jst.SpringCapmates.transferObjects.StatisticsDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceTest {
	
	@Autowired
	UserStatisticsService userStatisticsService;
	
	@Autowired
	HistoryDao historyDao;
	
	@Test
	public void testUserRanking(){
		//when
		int ranking = userStatisticsService.getUserPositionInRanking(3L, 1L);
		
		//then
		assertEquals(1,ranking);
	}
	
	@Test
	public void testStats() {
		//given
		Integer averageScore = 52;
	
		//when
		StatisticsDto statisticsDto = userStatisticsService.getUserStatistics(3L);
		
		//then
		
		assertEquals(1,statisticsDto.getGamesDrawn());
		assertEquals(1,statisticsDto.getGamesWon());
		assertEquals(1,statisticsDto.getGamesLost());
		assertEquals(3,statisticsDto.getGamesPlayed());
		assertEquals(5,statisticsDto.getLevel());
		assertEquals(averageScore,statisticsDto.getAverageScore());
	}
	
	@Test
	public void testUserHistoryList(){
		//given
		List<History> givenList = new LinkedList<>();
		givenList.add(new History(1L, 3L, 45, Verdict.DRAW));
		givenList.add(new History(4L, 3L, 56, Verdict.DEFEAT));
		givenList.add(new History(1L, 3L, 55, Verdict.VICTORY));
		
	
		//when
		List<History> receivedList = userStatisticsService.getUserGameHistory(3L);
		
		//then
		for(int i = 0; i<3;i++){
			assertEquals(givenList.get(i).getGameId(),receivedList.get(i).getGameId());
			assertEquals(givenList.get(i).getScore(),receivedList.get(i).getScore());
			assertEquals(givenList.get(i).getUserId(),receivedList.get(i).getUserId());
			assertEquals(givenList.get(i).getVerdict(),receivedList.get(i).getVerdict());
		}
		
	}

}
