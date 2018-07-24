package com.example.capgemini.jst.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.capgemini.jst.data.History;
import com.capgemini.jst.data.Verdict;

@Repository
public class HistoryDao {
	List<History> listOfHistory;

	private HistoryDao() {
		this.listOfHistory = new LinkedList<>();
		this.listOfHistory.add(new History(new AtomicLong(1), new AtomicLong(1), 25, Verdict.VICTORY));
		this.listOfHistory.add(new History(new AtomicLong(2), new AtomicLong(2), 30, Verdict.DEFEAT));
		this.listOfHistory.add(new History(new AtomicLong(1), new AtomicLong(3), 45, Verdict.DRAW));
		this.listOfHistory.add(new History(new AtomicLong(4), new AtomicLong(3), 56, Verdict.DEFEAT));
		this.listOfHistory.add(new History(new AtomicLong(1), new AtomicLong(3), 55, Verdict.VICTORY));
	}

	public List<History> filterByUserId(AtomicLong userId) {
		return  listOfHistory.stream().filter(p -> p.getUserId() == userId)
				.collect(Collectors.toList());
	}
	
	public List<History> filterByGameId(AtomicLong gameId) {
		return  listOfHistory.stream().filter(p -> p.getGameId() == gameId)
				.collect(Collectors.toList());
	}
	

	public void create(History history) {
		
	}

	public void update(History history) {

	}

	public void delete(History history) {
		
	}

}
