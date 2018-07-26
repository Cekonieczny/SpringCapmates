package com.capgemini.jst.SpringCapmates.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.SpringCapmates.data.UserHoursOfAvailability;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;
import com.capgemini.jst.SpringCapmates.repositories.UserHoursOfAvailabilityDao;
import com.capgemini.jst.SpringCapmates.services.UserHoursOfAvailabilityService;
import com.capgemini.jst.SpringCapmates.services.UserProfileService;
import com.capgemini.jst.SpringCapmates.transferObjects.UserHoursOfAvailabilityDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserHoursOfAvailabilityTest {

	@Autowired
	UserHoursOfAvailabilityService userHoursOfAvailabilityService;

	@Autowired
	UserHoursOfAvailabilityDao userHoursOfAvailabilityDao;

	@Test
	public void getMatchedUsersListTest() {
		// given
		LinkedList<Long> givenListOfUserIds = new LinkedList<>();
		givenListOfUserIds.add(2L);
		givenListOfUserIds.add(3L);
		givenListOfUserIds.add(4L);
		givenListOfUserIds.add(6L);
		givenListOfUserIds.add(7L);

		// when
		List<Long> receivedList = userHoursOfAvailabilityService.getListOfPlayersToChallenge(1L, 30);
		// then
		for (int i = 0; i < 5; i++) {
			assertEquals(givenListOfUserIds.get(i), receivedList.get(i));
		}
	}

	@Test
	public void addUserHoursOfAvailabilityTest(){
		//given
		//added object will be on 9th place in the list
		LocalTime from10 = LocalTime.of(11, 30);
		LocalTime to10 = LocalTime.of(12, 30);
		LocalDate date10 = LocalDate.of(2018, 12, 25);
		UserHoursOfAvailabilityDto givenUserHoursOfAvailabilityDto = new UserHoursOfAvailabilityDto(from10,to10, date10, 1L);
		//when
		
		userHoursOfAvailabilityService.addUserHoursOfAvailability(givenUserHoursOfAvailabilityDto);
		//then
		assertEquals(givenUserHoursOfAvailabilityDto.getDate(),userHoursOfAvailabilityDao.findAll().get(9).getDate());
		assertEquals(givenUserHoursOfAvailabilityDto.getComment(),userHoursOfAvailabilityDao.findAll().get(9).getComment());
		assertEquals(givenUserHoursOfAvailabilityDto.getFrom(),userHoursOfAvailabilityDao.findAll().get(9).getFrom());
		assertEquals(givenUserHoursOfAvailabilityDto.getTo(),userHoursOfAvailabilityDao.findAll().get(9).getTo());
		assertEquals(givenUserHoursOfAvailabilityDto.getUserId(),userHoursOfAvailabilityDao.findAll().get(9).getUserId());
	}
}
