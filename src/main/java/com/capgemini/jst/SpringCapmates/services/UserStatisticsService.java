package com.capgemini.jst.SpringCapmates.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.jst.SpringCapmates.data.History;
import com.capgemini.jst.SpringCapmates.data.Verdict;
import com.capgemini.jst.SpringCapmates.repositories.HistoryDao;
import com.capgemini.jst.SpringCapmates.transferObjects.StatisticsDto;

@Service
public class UserStatisticsService {
	private final HistoryDao historyDao;

	@Autowired
	public UserStatisticsService(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	public StatisticsDto getUserStatistics(Long userId) {
		List<History> userGameHistory = historyDao.filterByUserId(userId);
		Integer sumOfScores = 0;
		int sumOfDefeats = 0;
		int sumOfVictories = 0;
		int sumOfDraws = 0;

		for (History history : userGameHistory) {
			sumOfScores = sumOfScores + history.getScore();
			if (history.getVerdict() == Verdict.VICTORY) {
				sumOfVictories = sumOfVictories + 1;
			} else if (history.getVerdict() == Verdict.DEFEAT) {
				sumOfDefeats = sumOfDefeats + 1;
			} else if (history.getVerdict() == Verdict.DRAW) {
				sumOfDraws = sumOfDraws + 1;
			}
		}

		StatisticsDto statisticsDto = new StatisticsDto();
		statisticsDto.setGamesPlayed(userGameHistory.size());
		statisticsDto.setGamesWon(sumOfVictories);
		statisticsDto.setGamesDrawn(sumOfVictories);
		statisticsDto.setGamesLost(sumOfVictories);
		if (userGameHistory.size() != 0) {
			statisticsDto.setAverageScore(sumOfScores / userGameHistory.size());
		} else {
			statisticsDto.setAverageScore(0);
		}
		return statisticsDto;
	}
	
	public List<History> getUserGameHistory(Long userId){
		return historyDao.filterByUserId(userId);
	}

	public LinkedHashMap<Long, Integer> getGameRanking(Long gameId) {
		List<History> historyByGameId = historyDao.filterByGameId(gameId);

		Map<Long, Integer> userScoresMap = new HashMap<Long, Integer>();

		for (History history : historyByGameId) {
			if (userScoresMap.get(history.getUserId()) == null) {
				userScoresMap.put(history.getUserId(), history.getScore());
			} else {
				Integer updatedScore = userScoresMap.get(history.getUserId()) + history.getScore();
				userScoresMap.put(history.getUserId(), updatedScore);
			}
		}

		Stream<Map.Entry<Long, Integer>> sortedMap = userScoresMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue());

		LinkedHashMap<Long, Integer> rankingMap = sortedMap
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		// czy (e1, e2) -> e1 znaczy tyle co ten for powyzej?

		return rankingMap;
	}

	public int getUserPositionInRanking(Long userId, Long gameId) {
		List<Long> rankingList = getGameRanking(gameId).keySet().stream().collect(Collectors.toList());
		return rankingList.indexOf(userId)+1;
	}
	
	public int getLevel(){
		return 0;
		//czy mozna korzystać z metody getuserstatistics
	}
	
}
