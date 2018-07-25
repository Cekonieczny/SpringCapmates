package com.example.capgemini.jst.SpringCapmates;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.data.History;
import com.capgemini.jst.data.Verdict;
import com.capgemini.jst.services.UserStatisticsService;
import com.capgemini.jst.transferObjects.StatisticsDto;
import com.example.capgemini.jst.repositories.HistoryDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCapmatesApplicationTests {

	//@Autowired
	//UserStatisticsService userStatisticsService;
	
	//@Autowired
	//HistoryDao historyDao;
	
	@Test
	public void contextLoads() {
	}
	
	
	
	
	@Test
	public void testRankingMap() {
		//given
		HistoryDao historyDao = new HistoryDao();
		UserStatisticsService userStatisticsService = new UserStatisticsService(historyDao);
		LinkedHashMap<Long,Integer> givenMap = new LinkedHashMap<Long, Integer>();
		
		givenMap.put( 3L, 100);
		givenMap.put( 1L, 25);
		givenMap.put( 7L, 20);
		givenMap.put( 6L, 10);
		givenMap.put( 5L, 5);
		
		
		
	
		
		//when
		LinkedHashMap<Long,Integer> receivedMap = userStatisticsService.getGameRanking(1L);
		List<Long> receivedList = receivedMap.keySet().stream().collect(Collectors.toList());

		//then
		System.out.println(receivedList);
		assertEquals(givenMap,receivedMap);
	}
	
	@Test
	public void testUserRanking() {
		//given
		HistoryDao historyDao = new HistoryDao();
		UserStatisticsService userStatisticsService = new UserStatisticsService(historyDao);

		//when
		int ranking = userStatisticsService.getUserPositionInRanking(3L, 1L);

		//then
		assertEquals(1,ranking);
	}
	
	@Test
	public void testStats() {
		//given
		HistoryDao historyDao = new HistoryDao();
		UserStatisticsService userStatisticsService = new UserStatisticsService(historyDao);
		Integer averageScore = 52;
	
		//when
		StatisticsDto statisticsDto = userStatisticsService.getUserStatistics(3L);
		
		//then
		
		assertEquals(1,statisticsDto.getGamesDrawn());
		assertEquals(1,statisticsDto.getGamesWon());
		assertEquals(1,statisticsDto.getGamesLost());
		assertEquals(3,statisticsDto.getGamesPlayed());
		assertEquals(averageScore,statisticsDto.getAverageScore());
	}

}
