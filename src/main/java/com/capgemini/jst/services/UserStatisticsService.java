package com.capgemini.jst.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jst.data.History;
import com.capgemini.jst.data.Verdict;
import com.capgemini.jst.transferObjects.StatisticsDto;
import com.example.capgemini.jst.repositories.HistoryDao;

@Service
public class UserStatisticsService {
	private final HistoryDao historyDao;

	@Autowired
	public UserStatisticsService(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	public StatisticsDto getUserStatistics(AtomicLong userId) {
		List<History> userGameHistory = historyDao.filterByUserId(userId);
		Integer sumOfResults = null;
		StatisticsDto statisticsDto = null;
		int sumOfDefeats = 0;
		int sumOfVictories = 0;
		int sumOfDraws = 0;


		while (userGameHistory.stream().iterator().hasNext()) {
			sumOfResults = +userGameHistory.stream().iterator().next().getScore();
			if (userGameHistory.stream().iterator().next().getVerdict() == Verdict.VICTORY) {
				sumOfVictories = sumOfVictories++;
			}
			else if (userGameHistory.stream().iterator().next().getVerdict() == Verdict.DEFEAT) {
				sumOfDefeats = sumOfDefeats++;
			}
			else if (userGameHistory.stream().iterator().next().getVerdict() == Verdict.DRAW) {
				sumOfDraws = sumOfDraws++;
			}
		}
		statisticsDto.setGamesPlayed(userGameHistory.size());
		statisticsDto.setGamesWon(sumOfVictories);
		statisticsDto.setGamesDrawn(sumOfVictories);
		statisticsDto.setGamesLost(sumOfVictories);
		statisticsDto.setAverageResult(sumOfResults / userGameHistory.size());
		return statisticsDto;

	}

	public List<History> getGameRanking(AtomicLong gameId) {
		return historyDao.filterByGameId(gameId).stream().sorted((o1, o2) -> o1.getScore().compareTo(o2.getScore()))
				.collect(Collectors.toList());

	}
}
