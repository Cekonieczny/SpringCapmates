package com.capgemini.jst.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.data.History;
import com.capgemini.jst.data.Verdict;

@Repository
public class HistoryDao {
	List<History> listOfHistory;
	
	@Autowired
	public HistoryDao() {
		listOfHistory = new LinkedList<>();
		listOfHistory.add(new History(1L, 1L, 25, Verdict.VICTORY));
		listOfHistory.add(new History(2L, 2L, 30, Verdict.DEFEAT));
		listOfHistory.add(new History(1L, 3L, 45, Verdict.DRAW));
		listOfHistory.add(new History(4L, 3L, 56, Verdict.DEFEAT));
		listOfHistory.add(new History(1L, 3L, 55, Verdict.VICTORY));
		listOfHistory.add(new History(1L, 7L, 20, Verdict.VICTORY));
		listOfHistory.add(new History(1L, 6L, 10, Verdict.VICTORY));
		listOfHistory.add(new History(1L, 5L, 5, Verdict.VICTORY));
	}

	public List<History> filterByUserId(Long userId) {
		return  listOfHistory.stream().filter(p -> p.getUserId().equals(userId))
				.collect(Collectors.toList());
	}
	
	public List<History> filterByGameId(Long gameId) {
		return  listOfHistory.stream().filter(p -> p.getGameId().equals(gameId))
				.collect(Collectors.toList());
	}
	

	public void create(History history) {
		listOfHistory.add(history);
	}

	public void delete(History history) {
		listOfHistory.remove(history);
	}

}
