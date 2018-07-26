package com.capgemini.jst.SpringCapmates.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.SpringCapmates.repositories.HistoryDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectTest {
	@Autowired
	private HistoryDao historyDao;

	@Test
	public void shouldTest() {
		historyDao.filterByGameId(1L);
		historyDao.filterByUserId(2L);
	}
}
